package org.apache.jsp.Room;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Account;
import utils.Configs;

public final class viewDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/jspf/header2.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> IsolatedMS </title>\n");
      out.write("        \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("        <meta name =\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link rel=\"icon\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logoInHtml.jpg\" type=\"image/icon type\">\n");
      out.write("\n");
      out.write("        <!-- CSS File -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/reset.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/js/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/base.css\">        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/header.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/header2.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/toast.css\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js\" integrity=\"sha512-yFjZbTYRCJodnuyGlsKamNE/LlEaEAxSUDe5+u61mV8zzqJVFOH7TnULE2/PP/l5vKWpUNnF4VGVkXh3MjgLsg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>   \n");
      out.write("        <script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"header_one\">\n");
      out.write("                <span id='header_one-name'>Hệ thống quản lý khu cách ly Covid-19</span>\n");
      out.write("                <ul class='user'>\n");
      out.write("                    <li><a href=\"\"><i class=\"fa-solid fa-house-user\"></i>\n");
      out.write("                            <span>Thông báo</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"\"><i class=\"far fa-question-circle\"></i>\n");
      out.write("                            <span>Trợ giúp</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
  Account user = (Account) session.getAttribute("userLogin");
                        if (user == null) {
                    
      out.write("\n");
      out.write("                    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/login.jsp\">Đăng nhập</a></li>\n");
      out.write("                    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/register.jsp\">Đăng ký</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("            <div class='header_two row'>\n");
      out.write("                <div class=\"logo col-3\">\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logo.png\"></a>\n");
      out.write("                </div>\n");
      out.write("                ");
 } else {
      out.write("\n");
      out.write("                <li><div class=\"user-heading\">\n");
      out.write("                        <img id=\"avatar-login\" src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getUserName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                        <div class=\"user-info\">\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>                   \n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.jsp\">Đăng xuất</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("            <div class='header_two row'>\n");
      out.write("                <div class=\"logo col-3\">\n");
      out.write("                    <a href=\"\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logo.png\"></a>\n");
      out.write("                </div>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                <div class='search col-7'>\n");
      out.write("                    <form action =\"search\" method=\"POST\">\n");
      out.write("                        <input type=\"text\" class=\"search__text\" placeholder=\"Nhập để tìm kiếm\" id=\"key\" name=\"key\">\n");
      out.write("                        <button type=\"SUBMIT\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"toast\"></div>\n");
      out.write("\n");
      out.write("        <div style=\"clear: both\"></div>\n");
      out.write("        <div class=\"user-container row\">\n");
      out.write("            <div class=\"col-2 sidebar\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <img id=\"sidebar-avatar\" src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                        <span class=\"siderbar-nameuser\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUserName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                        <div class=\"space\"></div>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"\"><i class=\"fas fa-home sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Dashboard</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li active\" href=\"\"><i class=\"sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Home</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"#key\"><i class=\"sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Tìm kiếm</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 int acocuntTypeId;
                        try {
                            acocuntTypeId = user.getType().getAccountTypeId();
                        } catch (Exception e) {
                            acocuntTypeId = 0;
                        }

                        if (acocuntTypeId == 1) {  // Admin
                    
      out.write("\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Patient/list.jsp\"><i class=\"fas fa-user sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Người cách ly</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/view-detail-doctor.jsp\"><i class=\"fas fa-file-invoice sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Quản lý bác sĩ</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/view-detail-nurse.jsp\"><i class=\"fas fa-file-invoice sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Quản lý y tá</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Room/list.jsp\"><i class=\"fas fa-briefcase-medical sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Quản lý phòng</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    ");
 if (acocuntTypeId == 2) { // Doctor 
      out.write("  \n");
      out.write("\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Report/list.jsp\"><i class=\"fas fa-file-invoice sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Theo dõi sức khỏe</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Report/list.jsp\"><i class=\"fas fa-briefcase-medical sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Quản lý đơn thuốc</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    ");
 if (acocuntTypeId == 3) { // Nurse 
      out.write(" \n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Patient/list.jsp\"><i class=\"fas fa-user sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Người cách ly</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Room/list.jsp\"><i class=\"fas fa-briefcase-medical sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Quản lý phòng</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    ");
 if (acocuntTypeId == 4) { // Patient 
      out.write("  \n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"");
      out.print(request.getContextPath());
      out.write("/Report/list.jsp\"><i class=\"fas fa-file-invoice sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Báo cáo sức khỏe</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    <li><a class=\"sidebar-li\" href=\"\"><i class=\"fas fa-user-shield sidebar-icon\"></i>\n");
      out.write("                            <span class=\"sidebar-info\">Tài khoản</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/list/detail.css\">\n");
      out.write("<div class=\"col-10 content\">\n");
      out.write("    <div class=\"content-label\">\n");
      out.write("        <span class=\"content-label__menu\">Bảng điều khiển</span>\n");
      out.write("        <span class=\"content-label__info\"><i class=\"fas fa-home\"></i> > Hệ thống > Xem chi tiết phòng bệnh</span>\n");
      out.write("        <div class=\"spacer2\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"content-header\">\n");
      out.write("        <div class=\"content-header__info\">\n");
      out.write("            <span>Khu cách ly: </span>\n");
      out.write("            <span>Khu cách ly: </span>\n");
      out.write("            <span>Mã phòng:  -  Tên phòng: </span>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    <div class=\"content-middle\"> \n");
      out.write("        <div class=\"content-middle__lylich space3\">\n");
      out.write("            <span class=\"info-label\">Thông tin</span>\n");
      out.write("            <ul class=\"info-detail\">\n");
      out.write("                <li>Số giường tối đa: </li>\n");
      out.write("                <li>Số giường tối đa: </li>\n");
      out.write("                <li>Số bệnh nhân hiện có: </li>\n");
      out.write("                <li>Số bệnh nhân hiện có: </li>\n");
      out.write("                <li>Ghi chú: </li>\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </div>   \n");
      out.write("    <div class=\"content-history\">\n");
      out.write("        <span class=\"info-label\">Bệnh nhân hiện có</span>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("<div style=\"clear: both\"></div>\n");
      out.write("\n");
      out.write("<div id=\"footer\" class=\"row\">\n");
      out.write("    <!-- First Column -->\n");
      out.write("    <div class=\"col-3\">\n");
      out.write("        <h3 class=\"footer_selects\">About us</h3>\n");
      out.write("        We are very proud to announce that since 1999 we are very spreading awesomeness to our community and \n");
      out.write("        we have helped a lot of people to shape their better future and life! \n");
      out.write("        I hope we are doing best we can. If you have any kind of questions please call or contact us.\n");
      out.write("    </div>\n");
      out.write("    <!-- Second Column -->\n");
      out.write("    <div class=\"col-3\">\n");
      out.write("        <h3 class=\"footer_selects\">Contact details</h3>\n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("        <ul class=\"footer_links\">\n");
      out.write("            <li><i class=\"fas fa-map-marker-alt\"></i> 1, Dai Co Viet, Hai Ba Trung, Hanoi</li>\n");
      out.write("            <li><i class=\"fas fa-at\"></i>namnt153224@fpt.edu.vn</li>\n");
      out.write("            <li><i class=\"fas fa-phone-alt\"></i> 096934565 </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Third Column -->\n");
      out.write("    <div class=\"col-2\">\n");
      out.write("        <h3 class=\"footer_selects\">Socialize</h3>\n");
      out.write("        <br/>\n");
      out.write("        <a href=https://www.facebook.com/hoanghai.luu.71/\"\"><i class=\"fab fa-facebook-square footer-icon\"></i></a>\n");
      out.write("        <a href=\"\"><i class=\"fab fa-instagram footer-icon\"></i></a>\n");
      out.write("        <a href=\"\"><i class=\"fab fa-linkedin footer-icon\"></i></a>\n");
      out.write("    </div>\n");
      out.write("    <!-- Fourth Column -->\n");
      out.write("    <div class=\"col-4\"><br/><br/>\n");
      out.write("        <img class=\"footer-img\" src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/footer/tg.jpg\" />\n");
      out.write("    </div>\n");
      out.write("    <br/>\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("        <i class=\"far fa-copyright\"></i>\n");
      out.write("        COPYRIGHT BY 2022. DESIGN & DEVELOPMENT BY TEAM 3\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- END footer -->\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/js/toast.js\"></script>\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty notify}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    <script>\n");
        out.write("        toast({\n");
        out.write("            title: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getTittle()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\n");
        out.write("            message: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getMessage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\n");
        out.write("            type: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getType()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\n");
        out.write("            duration: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getDuration()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("        });\n");
        out.write("    </script>\n");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
