package com.fbty.base.activity;


import java.io.File;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;

public class ProductConfiguration
{
  public static final String CLIENT_VERSION = "MOTO_ANDROID1.6_1.6.0";
  static String HIDDEN;
  public static final String PRODUCT_NAME = "ifeng_android";
  public static String PUB_ID = "waptw";
  private static String SCREEN;
  static String VMAG_ROOT_PATH;
  public static boolean isNeedDisclamer = false;
  public static int screenHeight;
  public static int screenWidth;

  static
  {
    VMAG_ROOT_PATH = "/sdcard/ifeng_android/";
    HIDDEN = ".nomedia";
  }

  public static String getCacheDirectoryPath()
  {
    String str = String.valueOf(VMAG_ROOT_PATH);
    return str + "cache/";
  }

  public static String getCoverDirectoryPath()
  {
    String str = String.valueOf(VMAG_ROOT_PATH);
    return str + "cover/";
  }

  public static String getHiddenMediaPath()
  {
    String str1 = String.valueOf(VMAG_ROOT_PATH);
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = HIDDEN;
    return str2;
  }

  public static int getLeftVolumeInSDCard()
  {
    int i = 0;
    if (isSDCardAvailable())
    {
      String str1 = Environment.getExternalStorageDirectory().getPath();
      String str2 = new File(str1).getPath();
      StatFs localStatFs = new StatFs(str2);
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks() - 4L;
      i = (int)(l1 * l2 / 1024L / 1024L);
    }
    return i;
  }

  public static String getMagazineDirectoryPath()
  {
    String str = String.valueOf(VMAG_ROOT_PATH);
    return str + "download/";
  }

  public static String getRootPath()
  {
    return VMAG_ROOT_PATH;
  }

  public static String getScreenDescription()
  {
    if (SCREEN == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = screenWidth;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(120);
      int j = screenHeight;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(j);
      SCREEN = localStringBuilder1.toString();
    }
    return SCREEN;
  }

  public static String getSoftwareVersion(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str1 = paramContext.getPackageName();
      String str2 = localPackageManager.getPackageInfo(str1, 0).versionName;
      return str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localNameNotFoundException.printStackTrace();
    }
  }

  public static String getTempDirectoryPath()
  {
    String str = String.valueOf(VMAG_ROOT_PATH);
    return str + "temp/";
  }


  public static void initDirectoryPath()
  {
    String str1 = VMAG_ROOT_PATH;
    File localFile = new File(str1);
    boolean bool1;
	if (!localFile.exists())
       bool1 = localFile.mkdir();
    String str2 = getTempDirectoryPath();
    localFile = new File(str2);
    boolean bool2;
	if (!localFile.exists())
       bool2 = localFile.mkdir();
    String str3 = getCacheDirectoryPath();
    localFile = new File(str3);
    boolean bool3;
	if (!localFile.exists())
       bool3 = localFile.mkdir();
    String str4 = getCoverDirectoryPath();
    localFile = new File(str4);
    boolean bool4;
	if (!localFile.exists())
       bool4 = localFile.mkdir();
    String str5 = getMagazineDirectoryPath();
    localFile = new File(str5);
    boolean bool5;
	if (!localFile.exists())
       bool5 = localFile.mkdir();
    String str6 = getHiddenMediaPath();
    localFile = new File(str6);
    boolean bool6;
	if (!localFile.exists())
       bool6 = localFile.mkdir();
  }

  public static boolean isSDCardAvailable()
  {
    boolean flag = false ;
    if (Environment.getExternalStorageState().equals("mounted"))
      flag = true;
    return flag;
  }
}