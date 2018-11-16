package br.unip.greenhouse.servlets;

//<editor-fold defaultstate="collapsed" desc="Imports">
import br.unip.greenhouse.model.Actions;
import br.unip.greenhouse.model.Info;
import br.unip.greenhouse.view.GreenhouseAPI;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//</editor-fold>

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("UpdateInfo servlet: doGet");
        GreenhouseAPI ghAPI = new GreenhouseAPI();
        Info info = ghAPI.getInfo();
        
        request.setAttribute("info_inside_temp", new DecimalFormat("##.#").format(info.sensors.airTemperature));
        request.setAttribute("info_outside_temp", new DecimalFormat("##.#").format(info.airTemperature));
        request.setAttribute("info_inside_air_humidity", new DecimalFormat("##.#").format(info.sensors.airHumidity));
        request.setAttribute("info_outside_air_humidity", new DecimalFormat("##.#").format(info.airHumidity));
        request.setAttribute("info_soil_humidity", new DecimalFormat("##.#").format(info.sensors.soilHumidity));
        request.setAttribute("info_soil_ph", new DecimalFormat("##.##").format(info.sensors.soilPh));
        
        Actions a = ghAPI.getActions();
        request.setAttribute("current_light", (a.light)? "checked" : "");
        request.setAttribute("current_water", (a.water) ? "checked" : "");
        request.setAttribute("current_exaust", (a.exaust) ? "checked" : "");
        System.out.println("FROM DATABASE: light: " + a.light + " water: " + a.water + " exaust: "+a.exaust);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("UpdateInfo servlet: doPost");
        boolean light, water, exaust;
        light = Boolean.parseBoolean(request.getParameter("input_light"));
        water = Boolean.parseBoolean(request.getParameter("input_water"));
        exaust = Boolean.parseBoolean(request.getParameter("input_exaust"));
        
        saveActions(light, water, exaust);
        response.sendRedirect("home.jsp");
    }

    public void saveActions(boolean light, boolean water, boolean exaust){
        GreenhouseAPI ghAPI = new GreenhouseAPI();      
        ghAPI.setActions(new Actions(light, water, exaust));
    }

}
