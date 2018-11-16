package br.unip.greenhouse.servlets;

//<editor-fold defaultstate="collapsed" desc="Imports">
import br.unip.greenhouse.model.Info;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.unip.greenhouse.view.GreenhouseAPI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
//</editor-fold>

public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GreenhouseAPI ghAPI = new GreenhouseAPI();
        System.out.println("StatusHistory servelet: doGet");
        List<Info> infoList = ghAPI.listInfo();

        String tableCode = buildTable(infoList);
        request.setAttribute("table_rows", tableCode);
        request.getRequestDispatcher("history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GreenhouseAPI ghAPI = new GreenhouseAPI();
        System.out.println("StatusHistory servelet: doPost");

        String dates = request.getParameter("date_range");
        List<Info> infoList = ghAPI.listInfo(dates);
        String tableCode = buildTable(infoList);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(tableCode);
    }

    public String buildTable(List<Info> infoList) {
        StringBuilder sb = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sb.append("<tr>");
        sb.append("<th id=\"th_date\">  Data </th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_temp-in.png\"/> &nbsp;&nbsp;ºC</th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_temp-out.png\"/> &nbsp;&nbsp;ºC</th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_humidity-in.png\"/> &nbsp;&nbsp;%</th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_humidity-out.png\"/> &nbsp;&nbsp;%</th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_soil-humidity.png\"/> &nbsp;&nbsp;%</th>");
        sb.append("<th> <img class=\"item_icon\" src=\"images/icon_soil-ph.png\"/> &nbsp;&nbsp;PH</th>");
        sb.append("</tr>");

        for (Info info : infoList) {
            sb.append("<tr>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(dateFormat.format(info.date));
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.sensors.airTemperature);
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.airTemperature);
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.sensors.airHumidity);
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.airHumidity);
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.sensors.soilHumidity);
            sb.append("</h2></td>");
            sb.append("<td><h2 class=\" item_value\">");
            sb.append(info.sensors.soilPh);
            sb.append("</h2></td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }

}
