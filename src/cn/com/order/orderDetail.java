 package cn.com.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.pojo.OrderDetail;
import cn.com.service.orderDetailService;
import cn.com.service.impl.orderDetailServiceImpl;


public class orderDetail extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			orderDetailService orderdetailserver = new orderDetailServiceImpl();
			String s = null;
			s = req.getQueryString();
		    
			List pp = orderdetailserver.getOrderDetailList(s);
			toOrderDetailList(resp, pp);
		} catch (Exception e){
			toError(resp,e.getMessage());
		}	
		
	}
	
	private void toError(HttpServletResponse resp, String message) throws IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Error</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Error</h2>");
		out.println("	<hr>");
		out.println("	System Error," + message + "!");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	private void toOrderDetailList(HttpServletResponse resp, List orderdetailList)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//resp.setCharacterEncoding("utf-8");�ĳ����Ҳ�ԡ�
		PrintWriter out  = resp.getWriter();
		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>���ڵ��������Ż�</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"���ڵ��������Ż�\">");
		out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");//"css/tarena.css�����·��"  ��/css/tarena.css�Ǿ���·����
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\" images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\" images/top_bg.gif\">��</td>");
		out.println("				<td width=\"31%\" background=\" images/top_bg.gif\" align=\"right\"><img src=\" images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td background=\" images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/productList\"><img name=\"Image1\" border=\"0\" src=\" images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/userManage\"><img name=\"Image2\" border=\"0\" src=\" images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/shoppingCart\"><img name=\"Image4\" border=\"0\" src=\" images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/orderList\"><img name=\"Image5\" border=\"0\" src=\" images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/productList\"><img name=\"Image6\" border=\"0\" src=\" images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("");
		out.println("					>> ��ӭ���� <b>���ڵ��������Ż�</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("");
		out.println("<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\" images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href= index.jsp>���ڵ��������Ż�</a> �� <a href=\"/Demo/orderList\">�����б�</a>  �� <b>������ϸ</b>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		
		for(Iterator<OrderDetail> it = orderdetailList.iterator(); it.hasNext();){
			OrderDetail orderdetail = it.next();
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>�û���Ϣ</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>�û�����</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>��ϵ��ַ��</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>�ʱࣺ</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>��ͥ�绰��</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>�칫�ҵ绰��</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>�ֻ���</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>Email��ַ��</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			tarena");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>���ʽ</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+orderdetail.getPaystyle()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("		");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		");
		out.println("		");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("		<tr>");
		out.println("				<td colspan=\"5\" valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>��Ʒ�����嵥</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\"  align=\"center\" width=\"3%\">");
		out.println("					"+orderdetail.getLineid()+"");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"50%\"> ");
		out.println("    			&nbsp&nbsp"+orderdetail.getProductname()+"");
		out.println("    			</td>");
		out.println("    			<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"18%\"> ");
		out.println("    			�۸�"+orderdetail.getBasePrice()+"");
		out.println("    			</td>");
		out.println("    			<td class=tablebody1 valign=\"middle\" align=\"center\" width=\"14%\"> ");
		out.println("    			������"+orderdetail.getAmount()+"");
		out.println("    			</td>");
		out.println("    			<td class=tablebody2 valign=\"middle\" width=\"25%\"> ");
		out.println("    			С�ƣ�"+orderdetail.getCost()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("			<td colspan=\"4\" class=tablebody1 valign=\"middle\" width=\"75%\">");
		out.println("			");
		out.println("				</td>");
		out.println("			<td class=tablebody1 valign=\"middle\" width=\"25%\"> ");
		out.println("    			�ϼƣ�<font color=\"red\"><b>"+orderdetail.getCost()+"</b><font>");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("		</table>");
		}
		out.println("		<br>");
		out.println("		<br>");
		out.println("		");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- Body End -->");
		out.println("<!-- Footer Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("			<tr>");
		out.println("				<td height=\"17\" background=\" images/bot_bg.gif\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("			<tr>");
		out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("					<p align=\"center\">");
		out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
		out.println("					</p>");
		out.println("				</td>");
		out.println("");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Footer End -->");
		out.println("	</body>");
		out.println("</html>");
		out.println("");
		out.println("");
		out.println("");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
