package pl.edu.agh.soa;

public class AvatarDto {
    public boolean isOk;
    public String avatar;

    public AvatarDto() {
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
