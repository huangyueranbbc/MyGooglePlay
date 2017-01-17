package googleplay.hyr.com.mygoogleplay.pojo;

/**
 * 专题对象
 *
 * @author huangyueran
 * @date 2017-1-17 14:50:23
 */
public class SubjectInfo {

    public String url;
    public String des;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "url='" + url + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
