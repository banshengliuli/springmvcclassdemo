package cn.smbms.test;


import cn.smbms.dao.UserMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {

            SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
            SqlSessionFactory sqlSessionFactory;
            SqlSession sqlSession;
            String configFile = "mybatis-config.xml";

            List<Bill> list = null;

            try {
                    sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                    InputStream inputStream = Resources.getResourceAsStream(configFile);
                    sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
                    sqlSession=sqlSessionFactory.openSession();
                    //增
                    /*User user = new User();
                    user.setUserCode("weikongze");
                    user.setUserName("aaaa");
                    user.setUserPassword("123456");
                    user.setGender(1);
                    String birthadyString = "2000-4-4";
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sf.parse(birthadyString);
                    user.setBirthday(date);
                    user.setPhone("18919999999");
                    user.setAddress("兰州市城关区正宁路");
                    sqlSession.getMapper(UserMapper.class).addUser(user);
                    sqlSession.commit();*/
                    //修改
                    /*User user = new User();
                    user.setUserPassword("666666");
                    user.setGender(2);
                    user.setPhone("11011011010");
                    user.setAddress("兰州市安宁区派出所");
                    user.setId(16);
                    sqlSession.getMapper(UserMapper.class).updateUser(user);
                    sqlSession.commit();*/
                    //删除
                    /*sqlSession.getMapper(UserMapper.class).deleteUser(16);
                    sqlSession.commit();*/

                    //查询全部
                    /*list = sqlSession.getMapper(UserMapper.class).selectUserList();
                    for (User user1 : list) {
                            System.out.println(user1.getId().toString()+user1.getAddress()+user1.getUserName()+user1.getPhone());
                    }*/
                    //查询订单
                    Bill bill = new Bill();
                    bill.setProductName("洗发水");
                    bill.setProviderId(13);
                    bill.setIsPayment(2);
                    list = sqlSession.getMapper(UserMapper.class).selectBillList(bill);
                    for (Bill  bill1: list) {
                            System.out.println(bill1.getBillCode()+"\t"+bill1.getProductName()+"\t"+bill1.getProvider().getProName()+"\t"+bill1.getProvider().getProPhone()+"\t"+bill1.getProvider().getProContact()+"\t"+bill1.getTotalPrice()+"\t"+bill1.getIsPayment()+"\t"+bill1.getCreationDate());
                    }


            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
