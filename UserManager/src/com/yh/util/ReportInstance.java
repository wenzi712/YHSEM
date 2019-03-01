
package com.yh.util;

import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baidu.drapi.autosdk.core.CommonService;
import com.baidu.drapi.autosdk.core.ResHeader;
import com.baidu.drapi.autosdk.core.ResHeaderUtil;
import com.baidu.drapi.autosdk.core.ServiceFactory;
import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdData;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdRequest;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdResponse;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlData;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlRequest;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlResponse;
import com.baidu.drapi.autosdk.sms.service.GetReportStateData;
import com.baidu.drapi.autosdk.sms.service.GetReportStateRequest;
import com.baidu.drapi.autosdk.sms.service.GetReportStateResponse;
import com.baidu.drapi.autosdk.sms.service.ReportRequestType;
import com.baidu.drapi.autosdk.sms.service.ReportService;
import com.baidu.drapi.autosdk.util.DownloadUtil;
import com.opencsv.CSVReader;
import com.yh.mapper.report.ReportMapper;
import com.yh.pojo.parameter.Parameter;
import com.yh.pojo.regionReportData.RegionReportBean;
import com.yh.service.patameter.ParameterService;
import com.yh.service.report.ReportsService;
import com.yhsem.baidu.AccountInstance;
import com.yhsem.bean.KeywordReportDataBean;
import com.yhsem.bean.RegionReportDataBean;


/**
 * 
 * <b>类名称：</b>ReportInstance<br/>
 * <b>类描述：</b>〈一句话功能简述〉<br/>
 * <b>类详细描述：</b>〈功能详细描述〉<br/>
 * <b>创建人：</b>WangYi<br/>
 * <b>修改人：</b>WangYi<br/>
 * <b>修改时间：</b>2019-2-22 上午10:44:15<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version <br/>
 * 
 */
@Component
public class ReportInstance {

    private CommonService factory;
    private final AccountInstance account;
    @Autowired
    private ReportService reportService;
    private static String SUCCESS = "success";
    private ParameterService parameterService;
    @Autowired
    private ReportsService reportsService;
    @Autowired
    private ReportMapper reportMapper;

    public ReportInstance(AccountInstance account) {
        this.account = account;
        try {
            factory = ServiceFactory.getInstance();
            factory.setUsername(account.getFactory().getUsername());
            factory.setPassword(account.getFactory().getPassword());
            factory.setToken(account.getFactory().getToken());
            reportService = this.factory.getService(ReportService.class);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * getRegionReportId<br/>
     * 获取昨天日报<br/>
     * 
     * @return 返回服务器生成的报表 reportId
     * @throws Exception
     */
    public String getRegionReportId(boolean infoFlow) throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Timestamp endTime = new Timestamp(c.getTimeInMillis());
        endTime.setNanos(0);
        Date endDate = new Date(endTime.getTime());

        c.add(Calendar.DAY_OF_MONTH, -41);
        Timestamp startTime = new Timestamp(c.getTimeInMillis());
        startTime.setNanos(0);
        Date startDate = new Date(startTime.getTime());

        return getRegionReportId(startDate, endDate, infoFlow);
    }

    /**
     * getRegionReportId<br/>
     * 按照日期获取二级区域的日报结果<br/>
     * 
     * @param startTime
     *            开始时间,不能小于2008-10-31, 格式 yyyy-MM-dd HH:mm:ss
     * @param endTime
     *            开始时间,不能大于开始时间,格式 yyyy-MM-dd HH:mm:ss
     * @param infoFlow
     *            是否信息流
     * @return 返回服务器生成的报表 reportId
     * @throws Exception
     */
    public String getRegionReportId(Date startDate, Date endDate, boolean infoFlow) throws Exception {
        String reportId = "";
        GetProfessionalReportIdRequest request = new GetProfessionalReportIdRequest();

        ReportRequestType type = new ReportRequestType();
        List<String> performanceData = Arrays.asList(new String[] { "cost", "cpc", "click", "impression", "ctr", "cpm",
                "position" });
        type.setPerformanceData(performanceData);
        type.setLevelOfDetails(2);
        type.setUnitOfTime(5);
        type.setReportType(5);
        type.setStartDate(startDate);
        type.setEndDate(endDate);
        if (infoFlow) {
            type.setPlatform(23);// 信息流
        }

        request.setReportRequestType(type);
        GetProfessionalReportIdResponse response = reportService.getProfessionalReportId(request);

        if (response != null) {
            List<GetProfessionalReportIdData> datas = response.getData();
            if (datas != null) {
                System.out.println("response.getData() : " + datas);
                ResHeader rheader = ResHeaderUtil.getResHeader(reportService, true);
                if (SUCCESS.equals(rheader.getDesc()) && rheader.getStatus() == 0) {
                    reportId = datas.get(0).getReportId();
                }
            }
        }

        System.out.println(reportId);
        return reportId;
    }

    /**
     * getKeywordReportId<br/>
     * 获取昨日关键词日报<br/>
     * 
     * @return 返回服务器生成的报表 reportId
     * @throws Exception
     */
    public String getKeywordReportId(boolean infoFlow) throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Timestamp endTime = new Timestamp(c.getTimeInMillis());
        endTime.setNanos(0);
        Date endDate = new Date(endTime.getTime());

        c.add(Calendar.DAY_OF_MONTH, -1);// 不能大于31天
        Timestamp startTime = new Timestamp(c.getTimeInMillis());
        startTime.setNanos(0);
        Date startDate = new Date(startTime.getTime());

        return getKeywordReportId(startDate, endDate, infoFlow);
    }

    /**
     * getKeywordReportId<br/>
     * 按照日期获取关键词日报结果<br/>
     * 
     * @param startTime
     *            开始时间,不能小于2008-10-31, 格式 yyyy-MM-dd HH:mm:ss
     * @param endTime
     *            开始时间,不能大于开始时间,格式 yyyy-MM-dd HH:mm:ss
     * @param infoFlow
     *            是否信息流
     * @return 返回服务器生成的报表 reportId
     * @throws Exception
     */
    public String getKeywordReportId(Date startDate, Date endDate, boolean infoFlow) throws Exception {
        String reportId = "";
        GetProfessionalReportIdRequest request = new GetProfessionalReportIdRequest();
        ReportRequestType type = new ReportRequestType();
        List<String> performanceData = Arrays.asList(new String[] { "click", "impression", "cost" });
        type.setPerformanceData(performanceData);
        type.setLevelOfDetails(7);
        type.setUnitOfTime(5);
        type.setReportType(6);
        type.setStartDate(startDate);
        type.setEndDate(endDate);
        if (infoFlow) {
            type.setPlatform(23);// 信息流
        }

        request.setReportRequestType(type);
        GetProfessionalReportIdResponse response = reportService.getProfessionalReportId(request);

        if (response != null) {
            List<GetProfessionalReportIdData> datas = response.getData();
            if (datas != null) {
                System.out.println("response.getData() : " + datas);
                ResHeader rheader = ResHeaderUtil.getResHeader(reportService, true);
                if (SUCCESS.equals(rheader.getDesc()) && rheader.getStatus() == 0) {
                    reportId = datas.get(0).getReportId();
                }
            }
        }

        System.out.println(reportId);
        return reportId;
    }

    /**
     * getReportStateByReportId<br/>
     * 按照报告ID获取报告服务器状态<br/>
     * <br/>
     * 
     * @param reportId
     *            报告ID
     * @return 报告状态 [1：等待中; 2：处理中; 3：处理成功]
     * @throws Exception
     */
    public Integer getReportStateByReportId(String reportId) throws Exception {
        Integer isGenerated = 0;
        GetReportStateRequest request = new GetReportStateRequest();
        request.setReportId(reportId);
        GetReportStateResponse response = reportService.getReportState(request);
        List<GetReportStateData> datas = response.getData();
        System.out.println(datas);
        ResHeader rheader = ResHeaderUtil.getResHeader(reportService, true);
        if (SUCCESS.equals(rheader.getDesc()) && rheader.getStatus() == 0) {
            isGenerated = datas.get(0).getIsGenerated();
        }
        System.out.println(isGenerated);

        return isGenerated;
    }

    public String getReportFileUrlByReportId(String reportId) throws Exception {
        String reportFilePath = "";
        GetReportFileUrlRequest request = new GetReportFileUrlRequest();
        request.setReportId(reportId);
        GetReportFileUrlResponse response = reportService.getReportFileUrl(request);
        List<GetReportFileUrlData> datas = response.getData();
        System.out.println(datas);
        ResHeader rheader = ResHeaderUtil.getResHeader(reportService, true);
        if (SUCCESS.equals(rheader.getDesc()) && rheader.getStatus() == 0) {
            reportFilePath = datas.get(0).getReportFilePath();
        }
        System.out.println(reportFilePath);

        return reportFilePath;
    }

    public void testRegionReport(boolean infoFlow) {
    	
        try {
        	//1 给百度发个请求,说要上一天的二级区域报告,有个参数可以指定是不是信息流的报告,会返回一个报告ID
            String reportId = this.getRegionReportId(infoFlow);
            Parameter parameter = new Parameter();
            parameter.setReportId(reportId);
            parameter.setReportIdDate(new Date());
            // String reportId = "bcc39f6d1879ad99db634c3d9c443c18";
            Thread.sleep(20 * 1000); 
            //等一会 sleep,注意下,再去查下服务器有没有准备好这个报告 是 CSV格式的文本文件  
            Integer reportState = this.getReportStateByReportId(reportId);
            parameter.setReportState(reportState);
            parameter.setReportStateDate(new Date());
            System.out.println("reportState : " + reportState);
            if (reportState == 3) {
            	//如果服务器生成这个文件了. 就获取下URL地址
                String url = this.getReportFileUrlByReportId(reportId);
               // parameter.setReportUrl(url); 
                //parameter.setReportUrlDate(new Date());
                //parameterService.insertParameterInfo2(parameter);
                //根据获取的URL地址把文件以字节流的形式加载到内存,
                byte[] b = DownloadUtil.downloadFile(url);
                
                //使用第三方处理工具对CSV进行处理，
                CSVReader c = new CSVReader(new StringReader(new String(b, "GBK")), '\t');
            
               String[] nextLine;
                int n = 0;
                RegionReportDataBean tmp;
                while ((nextLine = c.readNext()) != null) {
                	RegionReportBean regionReportBean = new RegionReportBean();
                  n++;
                    if (n > 1) {
                    	//读取数据,构建一个数据Bean
                        tmp = new RegionReportDataBean(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
                                nextLine[5], nextLine[6], Integer.valueOf(nextLine[7]), Integer.valueOf(nextLine[8]),
                                Double.valueOf(nextLine[9]), nextLine[10], Double.valueOf(nextLine[9]),
                                Double.valueOf(nextLine[9]), Double.valueOf(nextLine[9]));
                        //System.out.println(tmp.toString());
                        //System.out.println(tmp.getCityId());
                        regionReportBean.setCity(tmp.getCity());
                        regionReportBean.setCityId(tmp.getCityId());
                        regionReportBean.setClicks(tmp.getClicks());
                        
                        reportsService.insertRegionReportDataBeanInfo(regionReportBean);
                    }
                    
                }
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
    }
    public void testKeywordReport(boolean infoFlow) {
        try {
            String reportId = this.getKeywordReportId(infoFlow);
            // String reportId = "bcc39f6d1879ad99db634c3d9c443c18";
            Thread.sleep(20 * 1000);
            Integer reportState = this.getReportStateByReportId(reportId);
            System.out.println("reportState : " + reportState);
            if (reportState == 3) {
                String url = this.getReportFileUrlByReportId(reportId);
                byte[] b = DownloadUtil.downloadFile(url);
                CSVReader c = new CSVReader(new StringReader(new String(b, "GBK")), '\t');
                String[] nextLine;
                int n = 0;
                KeywordReportDataBean tmp;
                while ((nextLine = c.readNext()) != null) {
                    n++;
                    if (n > 1) {
                        tmp = new KeywordReportDataBean(nextLine[0], nextLine[1], nextLine[2], nextLine[3],
                                nextLine[4], nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9],
                                nextLine[10], nextLine[11], nextLine[12], Integer.valueOf(nextLine[13]),
                                Integer.valueOf(nextLine[14]), Double.valueOf(nextLine[15]), nextLine[16], nextLine[17]);
                        System.out.println(tmp.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        AccountInstance account = new AccountInstance("searchlab", "SearchUX2016", "1085ffb557845b3d75d75b7762c8910a");
        ReportInstance report = new ReportInstance(account);
        report.testRegionReport(false);// 搜索渠道,二级区域报告
        // report.testRegionReport(true);//搜索信息流,二级区域报告  我i看下啊 是不是断电乱了
        // report.testKeywordReport(false);//搜索渠道,搜索词报告
        // report.testKeywordReport(true);//搜索信息流,搜索词报告
    }
    
}
