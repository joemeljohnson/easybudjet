package Model_Packages;

public class udm_dailytransaction {
    private String udmo_id;
    private String udmo_date;
    private String udmo_trantype;
    private String udmo_tranname;
    private String udmo_description;
    private Double udmo_amount;
    private String udmo_sign;
    private String udmo_ddcreate;
    private String udmo_month;
    private String udmo_year;
    private String udmo_isvalid;
    private String udmo_ddmodify;


    public String getUdmo_id(){ return udmo_id; }
    public void setUdmo_id( String id) { this.udmo_id = id; }
    public String getUdmo_date(){ return udmo_date; }

    public void setUdmo_date( String date) { this.udmo_date = date; }
    public String getUdmo_trantype(){ return udmo_trantype; }
    public void setUdmo_trantype( String trantype) { this.udmo_trantype = trantype; }

    public String getUdmo_tranname(){ return udmo_tranname; }
    public void setUdmo_tranname( String tranname) { this.udmo_tranname = tranname; }
    public String getUdmo_description(){ return udmo_description; }

    public void setUdmo_description( String description) { this.udmo_description = description; }
    public Double getUdmo_amount(){ return udmo_amount; }
    public void setUdmo_amount( Double amount) { this.udmo_amount = amount; }

    public String getUdmo_sign(){ return udmo_sign; }
    public void setUdmo_sign( String sign) { this.udmo_sign = sign; }
    public String getUdmo_ddcreate(){ return udmo_ddcreate; }

    public void setUdmo_ddcreate( String ddcreate) { this.udmo_ddcreate = ddcreate; }
    public String getUdmo_month(){ return udmo_month; }
    public void setUdmo_month( String month) { this.udmo_month = month; }

    public String getUdmo_year(){ return udmo_year; }
    public void setUdmo_year( String year) { this.udmo_year = year; }
    public String getUdmo_isvalid(){ return udmo_isvalid; }

    public void setUdmo_isvalid( String isvalid) { this.udmo_isvalid = isvalid; }
    public String getUdmo_ddmodify(){ return udmo_ddmodify; }
    public void setUdmo_ddmodify( String ddmodify) { this.udmo_ddmodify = ddmodify; }


}
