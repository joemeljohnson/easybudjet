package Model_Packages;

public class udm_monthopenning {
    private String udmo_id;
    private String udmo_ddmodify;
    private String udmo_ddcreate;
    private String udmo_year;
    private String udmo_sign;
    private String udmo_gentype;
    private String udmo_month;

    public String getUdmo_id(){ return udmo_id; }
    public void setUdmo_id( String id) { this.udmo_id = id; }

    public String getUdmo_month(){ return udmo_month; }
    public void setUdmo_month( String month) { this.udmo_month = month; }

    public String getUdmo_gentype(){ return udmo_gentype; }
    public void setUdmo_gentype( String gentype) { this.udmo_gentype = gentype; }

    public String getUdmo_sign(){ return udmo_sign; }
    public void setUdmo_sign( String sign) { this.udmo_sign = sign; }

    public String getUdmo_year(){ return udmo_year; }
    public void setUdmo_year( String year) { this.udmo_year = year; }

    public String getUdmo_ddcreate(){ return udmo_ddcreate; }
    public void setUdmo_ddcreate( String ddcreate) { this.udmo_ddcreate = ddcreate; }

    public String getUdmo_ddmodify(){ return udmo_ddmodify; }
    public void setUdmo_ddmodify( String ddmodify) { this.udmo_ddmodify = ddmodify; }

}
