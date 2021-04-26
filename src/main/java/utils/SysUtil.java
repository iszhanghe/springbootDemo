package utils;

public class SysUtil {

    public static String getCurLineInfo() {

        int originStackIndex = 2;
        
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[originStackIndex];

        String retStr = "【文件】" + element.getFileName() + "【类】" + element.getClassName() +
                "【方法】" + element.getMethodName() + "【行号】" + element.getLineNumber() + "\n";

        return retStr;
    }
}
