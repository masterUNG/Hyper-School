package appewtc.masterung.hyperschool;

/**
 * Created by masterUNG on 10/27/2016 AD.
 */

public class MyConstant {

    //Explicit
    private String[] subjectStrings = new String[]{
            "เคมี",
            "พละ",
            "สุขศึกษา",
            "ภาษาไทย",
            "เลข",
            "การงาน"};
    private String urlAddQuestionString = "http://swiftcodingthai.com/voc/add_question_master.php";

    public String getUrlAddQuestionString() {
        return urlAddQuestionString;
    }

    public String[] getSubjectStrings() {
        return subjectStrings;
    }
}   // Main Class
