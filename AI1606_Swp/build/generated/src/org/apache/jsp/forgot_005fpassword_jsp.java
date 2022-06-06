package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Account;
import utils.Configs;

public final class forgot_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title> IsolatedMS </title>\r\n");
      out.write("        \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \r\n");
      out.write("        <meta name =\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"icon\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logoInHtml.jpg\" type=\"image/icon type\">\r\n");
      out.write("        <!-- CSS File -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/reset.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/bootstrap/js/jquery.min.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/base.css\">        \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/header.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/header2.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/base/toast.css\">\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js\" integrity=\"sha512-yFjZbTYRCJodnuyGlsKamNE/LlEaEAxSUDe5+u61mV8zzqJVFOH7TnULE2/PP/l5vKWpUNnF4VGVkXh3MjgLsg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>       \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"header_one\">\r\n");
      out.write("                <span id='header_one-name'>Hệ thống quản lý khu cách ly Covid-19</span>\r\n");
      out.write("                <ul class='user'>\r\n");
      out.write("                    <li><a href=\"\"><i class=\"far fa-bell\"></i>\r\n");
      out.write("                            <span>Thông báo</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"\"><i class=\"far fa-question-circle\"></i>\r\n");
      out.write("                            <span>Trợ giúp</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");
  Account userLogin = (Account) session.getAttribute("userLogin");
                        if (userLogin == null) {
                    
      out.write("\r\n");
      out.write("                    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/login.jsp\">Đăng nhập</a></li>\r\n");
      out.write("                    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/register.jsp\">Đăng ký</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <div class='header_two row'>\r\n");
      out.write("                <div class=\"logo col-3\">\r\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logo.png\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
 } else {
      out.write("\r\n");
      out.write("                <li><div class=\"user-heading\">\r\n");
      out.write("                        <img id=\"avatar-login\" src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getUserName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                        <div class=\"user-info\">\r\n");
      out.write("                            <ul class=\"user-info__list\">\r\n");
      out.write("                                <li class=\"user-info__item\"><a href=\"\">Tài khoản của tôi</a></li>\r\n");
      out.write("                                <li class=\"user-info__item\"><a href=\"\">Đơn của tôi</a></li> \r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>                   \r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.jsp\">Đăng xuất</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <div class='header_two row'>\r\n");
      out.write("                <div class=\"logo col-3\">\r\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/home\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/logo.png\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class='search col-7'>\r\n");
      out.write("                    <form action =\"\" method=\"POST\">\r\n");
      out.write("                        <input type=\"text\" class=\"search__text\" placeholder=\"Nhập để tìm kiếm\" id=\"key\" name=\"key\">\r\n");
      out.write("                        <button type=\"SUBMIT\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <div style=\"clear: both\"></div>\r\n");
      out.write("        <div id=\"toast\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/form.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-container\">\r\n");
      out.write("    <form action=\"ForgotPassword\" method=\"POST\" id=\"form-dn\" class=\"form\">\r\n");
      out.write("        <h3 class=\"heading\">Tìm lại mật khẩu</h3>\r\n");
      out.write("        <p class=\"desc\">Tìm lại mật khẩu để đăng nhập nào</p>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"spacer\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"ten_dang_nhap\" class=\"form-label\">Tên đăng nhập</label>\r\n");
      out.write("            <input id=\"ten_dang_nhap\" class=\"form-control\" name=\"username\" type=\"text\" >\r\n");
      out.write("            <span class=\"form-message\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"email\" class=\"form-label\">Email</label>\r\n");
      out.write("            <input id=\"email\" class=\"form-control\" name=\"email\" type=\"text\" >\r\n");
      out.write("            <span class=\"form-message\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button id=\"forgot\" class=\"form-submit\">Tiếp theo</button>\r\n");
      out.write("        <script>\r\n");
      out.write("            document.getElementById('forgot-alert').addEventListener('click', function () {\r\n");
      out.write("                Swal.fire({\r\n");
      out.write("                    position: 'top-end',\r\n");
      out.write("                    icon: 'success',\r\n");
      out.write("                    title: 'Mật khẩu mới của bạn đã thay đổi. Kiểm tra email của bạn để thấy sự thay đổi',\r\n");
      out.write("                    showConfirmButton: false,\r\n");
      out.write("                    timer: 1500\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("<script src=\"assets/js/validator.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("            Validator({\r\n");
      out.write("                form: \"#form-dn\",\r\n");
      out.write("                errorSelector: '.form-message',\r\n");
      out.write("                rules: [\r\n");
      out.write("                    Validator.isRequired(\"#username\"),\r\n");
      out.write("                    Validator.minLength(\"#email\", 6),\r\n");
      out.write("                ]\r\n");
      out.write("            });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \r\n");
      out.write("<div style=\"clear: both\"></div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"footer\" class=\"row\">\r\n");
      out.write("    <!-- First Column -->\r\n");
      out.write("    <div class=\"col-3\">\r\n");
      out.write("        <h3 class=\"footer_selects\">About us</h3>\r\n");
      out.write("        We are very proud to announce that since 1999 we are very spreading awesomeness to our community and \r\n");
      out.write("        we have helped a lot of people to shape their better future and life! \r\n");
      out.write("        I hope we are doing best we can. If you have any kind of questions please call or contact us.\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Second Column -->\r\n");
      out.write("    <div class=\"col-3\">\r\n");
      out.write("        <h3 class=\"footer_selects\">Contact details</h3>\r\n");
      out.write("        <br/>\r\n");
      out.write("        \r\n");
      out.write("        <ul class=\"footer_links\">\r\n");
      out.write("            <li><i class=\"fas fa-map-marker-alt\"></i> 1, Tan Xa, Hoa Lac, Hanoi</li>\r\n");
      out.write("            <li><i class=\"fas fa-at\"></i>namnt153224@fpt.edu.vn</li>\r\n");
      out.write("            <li><i class=\"fas fa-phone-alt\"></i> 096934565 </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Third Column -->\r\n");
      out.write("    <div class=\"col-2\">\r\n");
      out.write("        <h3 class=\"footer_selects\">Socialize</h3>\r\n");
      out.write("        <br/>\r\n");
      out.write("        <a href=https://www.facebook.com/thanhnamm511/\"\"><i class=\"fab fa-facebook-square footer-icon\"></i></a>\r\n");
      out.write("        <a href=\"\"><i class=\"fab fa-instagram footer-icon\"></i></a>\r\n");
      out.write("        <a href=\"\"><i class=\"fab fa-linkedin footer-icon\"></i></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Fourth Column -->\r\n");
      out.write("    <div class=\"col-4\"><br/><br/>\r\n");
      out.write("        <img class=\"footer-img\" src=\"");
      out.print(request.getContextPath());
      out.write("/assets/img/footer/tg.jpg\" />\r\n");
      out.write("    </div>\r\n");
      out.write("    <br/>\r\n");
      out.write("    <div class=\"footer-copyright\">\r\n");
      out.write("        <i class=\"far fa-copyright\"></i>\r\n");
      out.write("        COPYRIGHT BY 2022. DESIGN & DEVELOPMENT BY TEAM 3\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END footer -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/js/toast.js\"></script>\r\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
        out.write("\r\n");
        out.write("    <script>\r\n");
        out.write("        toast({\r\n");
        out.write("            title: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getTittle()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\r\n");
        out.write("            message: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getMessage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\r\n");
        out.write("            type: \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getType()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\",\r\n");
        out.write("            duration: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notify.getDuration()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("        });\r\n");
        out.write("    </script>\r\n");
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
