package com.bczm.widgetcollections.http;

/**
 * 项目中用到的api 接口
 * 大小写 转换 快捷键  Ctrl + shift + U
 * @author：Jorge on 2015/9/11 13:45
 */
public class NetUtils {


    public static final String BASE_URL_HTTP="http://api.icartoons.cn";

    // GET  请求 拿到  token   游客登录
    public static final String FETCH_VALID_TOKEN=BASE_URL_HTTP+"/v4/auth/user_login?" +
            "identifier=68a0f6a3d862&" +
            "login_type=4&" +
            "sig=F%2B7scGqvlltzWew6MDovtPShZ4JhtmZKO6Y4HXh8Cyk8hYf9LKh2I7DjjVxdOg2Wd2QVXizsaUzvERCdFwR3yKtwhQ4oK6TWtqHe9P4xkJM41OeNzM7FuXbtd36Vn15jNWLVSnW6mPgnFz4NXIgLNHFX%2B6M7oTY30WqU4zRd8II%3D&" +
            "terminal_identifier=000000000000000%7C68a0f6a3d862&" +
            "imsi=68a0f6a3d862";



    // GET  获取 首页 顶部 轮播  数据信息
   public  static  final String  FETCH_HOME_TOP_CONTENT=BASE_URL_HTTP+"/v4/contents/position.json?" +
        "posid=2&" +
        "sig=QUlxzaFec5I4u1Dw0sWjc2UwQxQYLeeoQKPMkP3%2FnlxVWAgMX2UjBLgAuzKzcWtNb26vIZMs2gh7kZo0qWG2GDZ2vpDfg4qSMmEe3LZyf%2B9dxtcM1rQPEKcVqefwH1KE3BypMwVh8hjaJT1oRXlplp1Je5eV6X%2Bemc82P22oeN4%3D";

    //  获取 推荐的留个具体 视频
   public static final  String FETCH_POPULAR_CONTENT = BASE_URL_HTTP+"/v4/contents/position.json?" +
            "posid=4&" +
            "sig=zdrMT6MixLboTnSmQkhxxCLlDRhwawXspuThHWpfqNHK9HGG0iq%2BnImW%2FhPOD2T7mbWJmPKiPQFKaXadthLbAxzgHbWMboH5FElJReqWMs1GtLAwWttAw8hL8Pf%2FFeaUWQ8FQZphvIBm8%2FORd5lC0G1Wj00NOsFGxMCIBX%2FH6%2Bw%3D";
    // 获取 推荐 频道
    public static final String  FETCH_RECOMMEND_CHANNELS=BASE_URL_HTTP+"/v4/contents/show_area.json?" +
            "type=1&" +
            "sig=d1MRdM3pqP5bScvS7P21hva77k3EbZWlEVUbqSUPjhX2NiMw4Quv5afyFSgZE1ndul6ODR0ZBwEQAM1yThc0gGthniD%2Bi%2F%2FSAA4Yjs4GyS1ghb5lDaqbasjF4Z%2BcpYH1lag8%2FIzbIrKIcAqOOS9%2BaYLq67dIyF0gh%2BqXm7JtiwU%3D";


    // 首页底部 推荐 应用
    public static final String  FETCH_RECOMMENDED_APP=BASE_URL_HTTP+"/v4/contents/position.json?" +
            "posid=7&" +
            "sig=CCRx9fiG6J2rT3rmNNi6cjSZPiuUSLpPtq9rtiwFvSGpuKSeWEvPZPCCysZIy6B1yEMGmS%2Bo%2B%2F0Ht7TKknLUy7C%2FQl1Dl0pWkJxvPW1EZY3VpiOpbmqR7dJxgUqLsoomMJ6zu2mXrS%2BXnqTATZl9AFV9PKHPqpqN5P1y2vgf5Bs%3D";


  public static  final String  Fetch_Video_content_id="";

    //http://api.icartoons.cn/v4/contents/guessenjoy?
    // content_id=2S201507052200092708&
    // type=1&
    // sig=jkHbE2FK5RIYKtaafgbdn9x6YMsmln%2BdA4JrwKv9Yu%2FpePmPGxiPsjggzqLcVpjEINK3%2BCvHeD58Yk8ZhRkYonB6j2%2B0uKD%2Fip3Pd%2FPfwIhfRZhPtyGBBEorpStcSu%2Bqy78OsGIewZeAqDYH9XNiJjN2y%2BcBeiBP5%2FNwfg3gHck%3D


}
