package org.grupoTP.clases.Usuarios;

import java.util.Objects;

public abstract class Cuenta {

    protected String nickname;
    protected String password;
    protected String mail;

    //region Constructores
    public Cuenta() {}

    public Cuenta(String nickname, String password, String mail) {
        this.nickname = nickname;
        this.password = password;
        this.mail = mail;
    }
    //endregion

    //region Getters and Setters

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //endregion

    //region ToString

    @Override
    public String toString() {
        return "Cuenta{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
    //endregion

    //region Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(nickname, cuenta.nickname) && Objects.equals(password, cuenta.password) && Objects.equals(mail, cuenta.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    //endregion
}
