package cn.com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.pojo.Product;
import cn.com.service.productListService;
import cn.com.service.impl.productListServiceImpl;



public class productList extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		try{
			
		
			productListService product =  new productListServiceImpl();
			
//			StudentService studentService = ServiceFactory.getStudentService();
			
			List ProductList = product.getProductList();

			toProductList(resp, ProductList);
			
		} catch (Exception e){
			toError(resp,e.getMessage());
		}
		
	}

	private void toError(HttpServletResponse resp, String message) throws IOException {
		resp.setContentType("charset=UTF-8");
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

	private void toProductList(HttpServletResponse resp, List ProductList)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>���ڵ��������Ż�</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"���ڵ��������Ż�\">");
		out.println("		<link href=\" css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\" images/top_bg.gif\"><img src=\" images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\" images/top_bg.gif\">��</td>");
		out.println("				<td width=\"31%\" background=\" images/top_bg.gif\" align=\"right\"><img src=\" images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("			<tr>");
		out.println("				<td background=\" images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\" /Demo/productList\"><img name=\"Image1\" border=\"0\" src=\" images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\" /Demo/userManage\"><img name=\"Image2\" border=\"0\" src=\" images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\" /Demo/shoppingCart\"><img name=\"Image4\" border=\"0\" src=\" images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\" /Demo/orderList\"><img name=\"Image5\" border=\"0\" src=\" images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\" /Demo/productList\"><img name=\"Image6\" border=\"0\" src=\" images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("					>> ��ӭ���� <b>���ڵ��������Ż�</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\" images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href= index.jsp>���ڵ��������Ż�</a> ��<img border=\"0\" src=\" images/dog.gif\" width=\"19\" height=\"18\">��ӭ<font color=\"red\">admin</font>���٣�");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>���</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"60%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>��Ʒ����</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>�۸�</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\" images/bg2.gif\" width=\"24%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>����</b>");
		out.println("					</font>");
		out.println("				</td>");

		for(Iterator<Product> it = ProductList.iterator();it.hasNext();){
			Product product = it.next();
			
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.println("						" +product.getProductid() + "");
			out.println("				</td>");
			out.println("				");
			out.println("    <td class=tablebody1 valign=\"middle\" width=\"60%\"> &nbsp;&nbsp;<a href=\" /Demo/productDetail?"+product.getProductid()+"\">"+ product.getName() + "</a> ");
			out.println("    </td>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.println("					" + product.getBasePrice() + "");
			out.println("				</td>");
			out.println("				");
			out.println("    <td class=tablebody1 valign=\"middle\" align=\"center\" width=\"24%\"> <a href=\" /Demo/shoppingCart\"><img border=\"0\" src=\" images/car_new.gif\" width=\"97\" height=\"18\"></a> ");
			out.println("    </td>");
			out.println("			</tr>   ");
		}
		
		
			out.println("<!-- Body End -->");
			out.println("<!-- Footer Start -->");
			out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
			out.println("			<tr>");
			out.println("				<td height=\"17\" background=\" images/bot_bg.gif\">");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("		</table>");
		
			out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.println("			<tr>");
			out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
			out.println("					<p align=\"center\">");
			out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
			out.println("					</p>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("		</table>");

		
		out.println("		</table>");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	

}
