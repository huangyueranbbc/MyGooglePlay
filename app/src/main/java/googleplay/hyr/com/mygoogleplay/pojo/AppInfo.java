package googleplay.hyr.com.mygoogleplay.pojo;

import java.util.ArrayList;

/**
 * 首页应用信息封装
 *
 * @author huangyueran
 * @date 2017-1-19 16:15:18
 */
public class AppInfo {

    public String des;
    public String downloadUrl;
    public String iconUrl;
    public String id;
    public String name;
    public String packageName;
    public long size;
    public float stars;

    //补充字段, 供应用详情页使用
    public String author;
    public String date;
    public String downloadNum;
    public String version;
    public ArrayList<SafeInfo> safe;
    public ArrayList<String> screen;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(String downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<SafeInfo> getSafe() {
        return safe;
    }

    public void setSafe(ArrayList<SafeInfo> safe) {
        this.safe = safe;
    }

    public ArrayList<String> getScreen() {
        return screen;
    }

    public void setScreen(ArrayList<String> screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "des='" + des + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", size=" + size +
                ", stars=" + stars +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", downloadNum='" + downloadNum + '\'' +
                ", version='" + version + '\'' +
                ", safe=" + safe +
                ", screen=" + screen +
                '}';
    }

    //当一个内部类是public static的时候, 和外部类没有区别
    public static class SafeInfo {
        public String safeDes;
        public String safeDesUrl;
        public String safeUrl;

        public String getSafeDes() {
            return safeDes;
        }

        public void setSafeDes(String safeDes) {
            this.safeDes = safeDes;
        }

        public String getSafeDesUrl() {
            return safeDesUrl;
        }

        public void setSafeDesUrl(String safeDesUrl) {
            this.safeDesUrl = safeDesUrl;
        }

        public String getSafeUrl() {
            return safeUrl;
        }

        public void setSafeUrl(String safeUrl) {
            this.safeUrl = safeUrl;
        }

        @Override
        public String toString() {
            return "SafeInfo{" +
                    "safeDes='" + safeDes + '\'' +
                    ", safeDesUrl='" + safeDesUrl + '\'' +
                    ", safeUrl='" + safeUrl + '\'' +
                    '}';
        }
    }
}
