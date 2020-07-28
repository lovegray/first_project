package VO;


public class FriendsVO {
   private int freind_no;
   private static String member_id;
   private String freind_id;
   
   public FriendsVO(int freind_no, String member_id, String freind_id) {
      this.freind_no = freind_no;
      this.member_id = member_id;
      this.freind_id = freind_id;
   }

   public int getFreind_no() {
      return freind_no;
   }

   public void setFreind_no(int freind_no) {
      this.freind_no = freind_no;
   }

   public String getMember_id() {
      return member_id;
   }

   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }

   public String getFreind_id() {
      return freind_id;
   }

   public void setFreind_id(String freind_id) {
      this.freind_id = freind_id;
   }
}