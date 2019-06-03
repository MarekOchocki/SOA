package pl.edu.agh.soa;

public class Token {
    public String tokenstr;

    public Token(String tokenstr) {
        this.tokenstr = tokenstr;
    }

    public Token() {
    }

    public String getTokenstr() {
        return tokenstr;
    }

    public void setTokenstr(String tokenstr) {
        this.tokenstr = tokenstr;
    }
}
