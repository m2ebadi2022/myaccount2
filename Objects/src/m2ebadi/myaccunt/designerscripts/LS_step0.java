package m2ebadi.myaccunt.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_step0{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 5;BA.debugLine="lbl_run2_step0.HorizontalCenter=50%x"[step0/General script]
views.get("lbl_run2_step0").vw.setLeft((int)((50d / 100 * width) - (views.get("lbl_run2_step0").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="Label4.HorizontalCenter=50%x"[step0/General script]
views.get("label4").vw.setLeft((int)((50d / 100 * width) - (views.get("label4").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="Label5.HorizontalCenter=50%x"[step0/General script]
views.get("label5").vw.setLeft((int)((50d / 100 * width) - (views.get("label5").vw.getWidth() / 2)));

}
}