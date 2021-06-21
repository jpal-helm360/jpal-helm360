package com.qa.javaLib;

public class DBConstant {

	/* Application Database For Staging : DBType=1 ====>> For Deleting ChatBot History  */
	public static final String AppDBURL_Staging = "jdbc:sqlserver://192.168.1.98:1433;databaseName=Terminus_Tpro";
	public static final String AppDBUser_Staging = "sa";
	public static final String AppDBPwd_Staging = "Welcome2helm";

	/* Application Database For Sales : DBType=1 ====>> For Deleting ChatBot History  */
	//public static final String AppDBURL_Sales = "jdbc:sqlserver://termi-tpro-prod-mac.database.windows.net:1433;database=Termi_TPro_Prod_Db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	//public static final String AppDBURL_Sales = "jdbc:sqlserver://termi-tpro-prod-mac.database.windows.net:1433;database=Termi_TPro_Prod_Db";
	public static final String AppDBURL_Sales ="jdbc:sqlserver://termi-tpro-prod-mac.database.windows.net:1433;database=Termi_TPro_Prod_Db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	public static final String AppDBUser_Sales = "Itfix";
	public static final String AppDBPwd_Sales = "YDL5jy1p";

	/* WhareHouse_1 Database For Staging : DBType=2 ====>> For Data Validation */
	//public static final String WHDBURL1_Staging = "jdbc:sqlserver://104.42.58.130:1433;databaseName=Prolaw_Warehouse_TR_Sales";
	public static final String WHDBURL1_Staging = "jdbc:sqlserver://104.42.58.130:1433;databaseName=TermiPro_DWH_Cloud4";
	public static final String WHDBUser1_Staging = "sa";
	public static final String WHDBPwd1_Staging = "W@lc0me2ccs!";

	/* WhareHouse_2 Database For Staging : DBType=3 ====>> For Data Validation */
	public static final String WHDBURL2_Staging = "jdbc:sqlserver://192.168.1.204:1433;databaseName=PL_STMN";
	public static final String WHDBUser2_Staging = "sa";
	public static final String WHDBPwd2_Staging = "Welcome2helm";

	/* WhareHouse_1 Database For Sales : DBType=2 ====>> For Data Validation */
	public static final String WHDBURL1_Sales = "jdbc:sqlserver://104.42.58.130:1433;databaseName=Prolaw_Warehouse_TR_Sales";
	public static final String WHDBUser1_Sales = "sa";
	public static final String WHDBPwd1_Sales = "W@lc0me2ccs!";

	/* WhareHouse_2 Database For Sales : DBType=3 ====>> For Data Validation */
	public static final String WHDBURL2_Sales = "jdbc:sqlserver://USCAVMTS16PR204:1433;databaseName=PL_STMN";
	public static final String WHDBUser2_Sales = "sa";
	public static final String WHDBPwd2_Sales = "Welcome2helm";

}
