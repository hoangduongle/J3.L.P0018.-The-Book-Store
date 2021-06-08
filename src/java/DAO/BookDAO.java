/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BookDTO;
import DTO.CategoryDTO;
import DTO.DetailDTO;
import DTO.DiscountDTO;
import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BookDAO {

    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ArrayList<BookDTO> getListBook() throws SQLException {
        ArrayList<BookDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                        + "from tblBook\n";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BookDTO(rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("Author"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<CategoryDTO> getListCategory() throws SQLException {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select CategoryID,CategoryName\n"
                        + "from tblCategory";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new CategoryDTO(rs.getInt("CategoryID"), rs.getString("CategoryName")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public BookDTO searchBookbyID(int ID) throws SQLException {
        BookDTO b = new BookDTO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                        + "from tblBook\n"
                        + "where BookID =?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    b = new BookDTO(rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("image"),
                            rs.getInt("Price"),
                            rs.getInt("quantity"),
                            rs.getString("Author"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return b;
    }

    public int updateBook(BookDTO b) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBook\n"
                        + "set BookName = ?,image = ?,Price=?,quantity=?,Author=?,CurrentDate=?,Status=?,CategoryID=?\n"
                        + "where BookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, b.getBookName());
                pst.setString(2, b.getImage());
                pst.setFloat(3, b.getPrice());
                pst.setInt(4, b.getQuantity());
                pst.setString(5, b.getAuthor());
                pst.setString(6, b.getCurrentDate());
                pst.setBoolean(7, b.isStatus());
                pst.setInt(8, b.getCategoryID());
                pst.setInt(9, b.getBookID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int insertBook(BookDTO b) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblBook values(?,?,?,?,?,?,'1',?)\n";
                pst = cn.prepareStatement(sql);
                pst.setString(1, b.getBookName());
                pst.setString(2, b.getImage());
                pst.setFloat(3, b.getPrice());
                pst.setInt(4, b.getQuantity());
                pst.setString(5, b.getAuthor());
                pst.setString(6, b.getCurrentDate());
                pst.setInt(7, b.getCategoryID());
                int result = pst.executeUpdate();
                return result;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int deleteBook(int id) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBook\n"
                        + "set Status=0\n"
                        + "where BookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                return pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public ArrayList<BookDTO> getListBookByCategoryID(int ID) throws SQLException {
        ArrayList<BookDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = null;
                if (ID == 0) {
                    sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                            + "from tblBook\n"
                            + "where Status = '1'";
                } else {
                    sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                            + "from tblBook\n"
                            + "where Status = '1' AND CategoryID = " + ID;

                }
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BookDTO(rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("Author"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<BookDTO> getListBookByName(String search) throws SQLException {
        ArrayList<BookDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                        + "from tblBook\n"
                        + "where Status = '1' AND BookName like '%" + search + "%'";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BookDTO(rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("Author"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public BookDTO getBookByBookID(int ID) throws SQLException {
        BookDTO b = new BookDTO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BookID,BookName,image,Price,quantity,Author,CurrentDate,Status,CategoryID\n"
                        + "from tblBook\n"
                        + "where BookID = ?";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    b = new BookDTO(rs.getInt("BookID"),
                            rs.getString("BookName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("Author"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return b;
    }

    public int getQuantityOfBook(int ID) throws SQLException {
        int quantity = 0;
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select quantity\n"
                        + "from tblBook\n"
                        + "where BookID = " + ID;
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return quantity;
    }

    public boolean insertDiscount(DiscountDTO dto) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblDiscount values(?,?,?,?,?);";
                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getDName());
                pst.setInt(2, dto.getDPercent());
                pst.setString(3, dto.getCodeName());
                pst.setString(4, dto.getBegindate());
                pst.setString(5, dto.getEnddate());
                return pst.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    public ArrayList<DiscountDTO> getAllDiscount() throws SQLException {
        ArrayList<DiscountDTO> list = new ArrayList();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select DiscountID, DName,DPercent,CodeName,Begindate,Enddate\n"
                        + "from tblDiscount";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new DiscountDTO(rs.getInt("DiscountID"),
                            rs.getString("DName"),
                            rs.getInt("DPercent"),
                            rs.getString("CodeName"),
                            rs.getString("Begindate"),
                            rs.getString("Enddate")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public DiscountDTO getDiscountbyID(int ID) throws SQLException {
        DiscountDTO dto = new DiscountDTO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select DiscountID, DName,DPercent,CodeName,Begindate,Enddate\n"
                        + "from tblDiscount\n"
                        + "where DiscountID = '" + ID + "'";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    dto = new DiscountDTO(rs.getInt("DiscountID"),
                            rs.getString("DName"),
                            rs.getInt("DPercent"),
                            rs.getString("CodeName"),
                            rs.getString("Begindate"),
                            rs.getString("Enddate"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return dto;
    }

    public boolean deleteDiscount(int ID) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "delete tblDiscount\n"
                        + "where DiscountID = '" + ID + "'";
                pst = cn.prepareStatement(sql);
                return pst.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    public int insertDetail(DetailDTO dto) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblDetail values(?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setFloat(1, dto.getPrice());
                pst.setInt(2, dto.getQuantity());
                pst.setInt(3, dto.getOrderID());
                pst.setInt(4, dto.getBook().getBookID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int insertOrder(OrderDTO dto) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblOrder values(?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getDateOrder());
                pst.setFloat(2, dto.getTotal());
                pst.setInt(3, dto.getUserID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int getOrderID() throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select top 1 OrderID\n"
                        + "from tblOrder\n"
                        + "order by OrderID desc";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("OrderID");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int updateQuantityOfBook(int BookID, int Bookquantity) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBook\n"
                        + "set quantity = ?\n"
                        + "where BookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Bookquantity);
                pst.setInt(2, BookID);
                return pst.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int deleteVoucher(int VoucherID) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "delete tblDiscount where DiscountID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, VoucherID);
                return pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public ArrayList<OrderDTO> listOrderID(int UserID) throws SQLException {
        ArrayList<OrderDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select OrderID, DateOrder, total\n"
                        + "from tblOrder\n"
                        + "where UserID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, UserID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new OrderDTO(rs.getInt("OrderID"),
                            rs.getString("DateOrder"),
                            rs.getFloat("total"),
                            UserID));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<DetailDTO> getListDetailByOrderID(int ID) throws SQLException {
        ArrayList<DetailDTO> list = new ArrayList<>();
        BookDAO dao = new BookDAO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select Price, quantity,OrderID,BookID\n"
                        + "from tblDetail\n"
                        + "where OrderID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    BookDTO dto = dao.getBookByBookID(rs.getInt("BookID"));
                    list.add(new DetailDTO(0, rs.getFloat("Price"), rs.getInt("quantity"), rs.getInt("OrderID"), dto));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        try {
            ArrayList<DetailDTO> list = dao.getListDetailByOrderID(5);
            for (DetailDTO detailDTO : list) {
                System.out.println(detailDTO.toString());
            }

            
        } catch (Exception e) {
        }
    }

}
