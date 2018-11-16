<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Greenhouse</title> 

        <!-- CSS -->
        <link href="css/home.css" rel="stylesheet" type="text/css"/>

        <!-- Scripts -->
        <script src="scripts/home.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Quicksand:300" rel="stylesheet">     

    </head>
    <body>
        <div id="main_conteiner">
            <div id="background_container"> 

                <!-- Header -->
                <div id="header_container">						
                    <h1 id="header_title">
                        <a href="home">
                            <img id="img_greenhouse_logo" src="images/greenhouse-logo.png"/>
                        </a>&nbsp;&nbsp;&nbsp;Greenhouse Management
                    </h1>
                </div>	

                <!-- Content -->
                <div id="content_container">

                    <div id="layout_conteiner">

                        <!-- Status -->
                        <div id="status_container" class="info">

                            <a href="history">
                                <h1 class="div_title">
                                    <img id="history-button" title="Histórico de status" src="images/icon_history-green.png">											
                                    </img>
                                    &nbsp;Status 
                                </h1>
                            </a>

                            <table>
                                <tr>
                                    <td class="item_icon"><img src="images/icon_temp-in.png"></img></td>
                                    <td class="item_label"><h2>Temperatura dentro </h2></td>
                                    <td class="item_value"><h2> ${info_inside_temp} ºC</h2></td>
                                </tr>
                                <tr>
                                    <td class="item_icon"><img src="images/icon_temp-out.png"></img></td>
                                    <td class="item_label"><h2>Temperatura fora </h2></td>
                                    <td class="item_value"><h2> ${info_outside_temp} ºC</h2></td>

                                </tr>
                                <tr>
                                    <td class="item_icon"><img src="images/icon_humidity-in.png"></img></td>
                                    <td class="item_label"><h2>Umidade do ar dentro </h2></td>
                                    <td class="item_value"><h2>${info_inside_air_humidity} %</h2></td>

                                </tr>
                                <tr>
                                    <td class="item_icon"><img src="images/icon_humidity-out.png"></img></td>
                                    <td class="item_label"><h2>Umidade do ar fora </h2></td>
                                    <td class="item_value"><h2> ${info_outside_air_humidity} %</h2></td>
                                </tr>
                                <tr>
                                    <td class="item_icon"><img src="images/icon_soil-humidity.png"></img></td>
                                    <td class="item_label"><h2>Umidade do solo </h2></td>
                                    <td class="item_value"><h2> ${info_soil_humidity} %</h2></td>
                                </tr>

                                <tr>
                                    <td class="item_icon"><img src="images/icon_soil-ph.png"></img></td>
                                    <td class="item_label"><h2>PH do solo </h2></td>
                                    <td class="item_value"><h2> ${info_soil_ph}</h2></td>
                                </tr>
                            </table>
                        </div>

                        <div id="separator">
                        </div>

                        <!-- Acoes -->
                        <div id="actions_container" class="info">
                            <h1 class="div_title"> Opções </h1>   

                            <table id="action_table">
                                <tr>
                                    <td class="item_icon">
                                        <img src="images/icon_light.png"/>
                                    </td>

                                    <td class="item_label">
                                        <h2> Luzes </h2>	
                                    </td>

                                    <td class="action_button">
                                        <label class="switch">                                              
                                            <input id="input_light" class="input_action" name="input_light" type="checkbox" ${current_light} onclick="checkboxClick()">
                                            <span class="slider round"></span>
                                        </label>                                            
                                    </td>
                                </tr>

                                <tr>
                                    <td class="item_icon">
                                        <img src="images/icon_watering-can.png"/>
                                    </td>

                                    <td class="item_label">
                                        <h2>Irrigação</h2> 	
                                    </td>

                                    <td class="action_button">
                                        <label class="switch">
                                            <input id="input_water" class="input_action" name="input_water" type="checkbox" ${current_water} onclick="checkboxClick()">
                                            <span class="slider round"></span>
                                        </label>                                            
                                    </td>
                                </tr>

                                <tr>
                                    <td class="item_icon">
                                        <img src="images/icon_fan.png"/>
                                    </td>

                                    <td class="item_label">
                                        <h2 >Exaustor</h2>	
                                    </td>

                                    <td class="action_button">
                                        <label class="switch">
                                            <input id="input_exaust" class="input_action" name="input_exaust" type="checkbox" ${current_exaust} onclick="checkboxClick()">
                                            <span class="slider round"></span>
                                        </label>                                            
                                    </td>
                                </tr>

                            </table>

                        </div>	
                    </div>
                </div>

                <!-- Footer -->
                <div id="footer">
                    <span id="footer_text"><b>Greenhouse Project </br>
                            2018</b></span>
                </div>
            </div>
        </div>
    </body>    
</html>




















