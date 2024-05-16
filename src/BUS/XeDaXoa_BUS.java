package BUS;
import DAO.*;

public class XeDaXoa_BUS 
{
    private XeDaXoa_DAO xeDaXoa_DAO = new XeDaXoa_DAO();

    public String[][] getAllXeMayDaXoa() {
        return xeDaXoa_DAO.getAllXeMayDaXoa();
    } 



}
