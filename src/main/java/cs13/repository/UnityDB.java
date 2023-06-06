package repository;

public class UnityDB {
    public static String ADD_CUSTOMER = " INSERT INTO customer(c_id,c_name) VALUES(?,?);";
    public static String FIND_ALL_CUSTOMER = "SELECT * FROM customer;";
    public static String FIND_BY_ID_CUSTOMER = "SELECT * FROM customer WHERE c_id = ?;";

    public static String EDIT_CUSTOMER = "UPDATE customer SET c_name = ? Where c_id = ?; ";

    public static String REMOVE_BY_ID_CUSTOMER = "DELETE FROM customer WHERE c_id = ?;";

    public static String FIND_ALL_PRODUCT = "SELECT * FROM product;";

    public static String ADD_PRODUCT = " INSERT INTO product(p_id,p_ame,p_rice,p_amount) VALUES(?,?,?,?);";

    public static String FIND_BY_ID_PRODUCT = "SELECT * FROM product WHERE p_id = ?;";

    public static String EDIT_PRODUCT = "UPDATE product SET  p_ame = ?,p_rice = ?,p_amount = ? WHERE p_id = ?; ";

    public static String DELETE_PRODUCT = "DELETE FROM product WHERE p_id = ?;";




}
