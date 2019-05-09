package zc.neu.com.securitystorage.sqlite.tables;


public class Tables {

  /**
   * SQLite 公用字段
   */
  public static final String RegistCode = "registcode";
  public static final String Time = "time";

	/**********************************************
	 *  SQLite V1
	 **********************************************/
	public static final String mNoteTable = "note";  // 便签表
	public static final String mNoteNativeId = "note_native_id";  // 本地存储id
	public static final String mNoteTitle = "note_title";  // 便签标题
	public static final String mNoteContent = "note_content";  // 便签内容
	public static final String mNoteCreateTime = "note_create_time"; // 便签创建时间
	public static final String mNoteModifyTime = "note_modify_time"; // 便签修改时间

  /**
   * SQLite K-V
   */
  public static final String mKVTable = "keyvalue";//密文键值对表
  public static final String mKVId = "kvid";
  //public static final String mKVRegistCode = "registcode";
  public static final String mKVkey = "key";
  public static final String mKVvalue = "value";

  /**
   * SQLite 对称密钥表
   */
  public static final String mKeyTable = "keytable";
  public static final String mKeyId = "keyid";
  //public static final String RegistCode = "registcode";
  public static final String mKeyk = "key";

  /**
   * SQLite 信息注册表
   */
  public static final String mRegistTable = "registtable";
  public static final String mRegistId = "registid";
  public static final String mRegistAppName = "appname";
  //public static final String mRegistCode = "code";

}
