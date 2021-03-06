package com.santrong.plt.system;




public class Global {
	
	/*
	 * static final config
	 */
	public static final String Default_Encoding = "UTF-8";
	public static final String SessionKey_LoginUser = "loginUser";
	public static final String SessionKey_AfterLoginUri = "afterLoginUri";
	public static final String SessionKey_Area = "area";
	public static final String RequestKey_TipError = "tipError";
	
	public static int UploadFileSizeLimit = 150;								// 升级文件大小限制，单位M----请确保tomcat限制大小不小于用户配置大小
    
	
    /*
     * [System]
     */
    public static String Version = "";
    public static String Title = "课云教育";
    public static String Language = "zh_CN";
    public static String PltDomain= "plttest.santrong.com";
    
    /*
     * [Ftp]
     */
    public static int FTPConnectMode = 0;								// 0主动模式，1被动模式
    
    /*
     * [User]
     */
    public static String AreaCode = "110000";						// 默认北京市
    public static String City = "北京";									// 默认北京市

    static {
        String configFile = Global.class.getClassLoader().getResource("") + "Config.ini";
        if (configFile.startsWith("file:/")) {
            configFile = configFile.substring(5);
        }
        
        Ini ini = new Ini();
        if (ini.read(configFile)) {
            Version = ini.readString("System", "Version", Version);
            Title = ini.readString("System", "Title", Title);
            Language = ini.readString("System", "Language", Language);
            PltDomain = ini.readString("System", "PltDomain", PltDomain);
            
            FTPConnectMode =ini.readInt("Ftp", "FTPConnectMode", FTPConnectMode);
        }
        
    }
    
}
