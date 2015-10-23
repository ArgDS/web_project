package app.mihailov.application.chat.service.data.domain;

import app.mihailov.application.chat.service.data.annotation.MColumn;
import app.mihailov.application.chat.service.data.annotation.MTable;

import java.util.Date;

/**
 * Created by Дмитрий
 * Date: 23.10.2015.
 */
@MTable(name = "user")
public class User {
    private Integer id;
    private String nikname;
    private String login;
    private String password;
    private Date dateCreate;
    private Date dateLastEnter;
    private boolean delete;

    @MColumn(name = "user_id", type = MColumn.TypeData.Int)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @MColumn(name = "user_nikname", type = MColumn.TypeData.String)
    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    @MColumn(name = "user_login", type = MColumn.TypeData.String)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @MColumn(name = "user_password", type = MColumn.TypeData.String)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @MColumn(name = "user_date_create", type = MColumn.TypeData.Date)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @MColumn(name = "user_date_last_enter")
    public Date getDateLastEnter() {
        return dateLastEnter;
    }

    public void setDateLastEnter(Date dateLastEnter) {
        this.dateLastEnter = dateLastEnter;
    }

    @MColumn(name = "user_delete", type = MColumn.TypeData.Boolean)
    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
