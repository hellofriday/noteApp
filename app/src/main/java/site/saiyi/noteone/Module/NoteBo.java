package site.saiyi.noteone.Module;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ding-syi on 2017/3/12.
 */
@Entity
public class NoteBo {
    @Id
    private Long id;

    private String time_stamp;

    private String detail;

    private int state;

    @Generated(hash = 821952168)
    public NoteBo(Long id, String time_stamp, String detail, int state) {
        this.id = id;
        this.time_stamp = time_stamp;
        this.detail = detail;
        this.state = state;
    }

    @Generated(hash = 1186570072)
    public NoteBo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime_stamp() {
        return this.time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
