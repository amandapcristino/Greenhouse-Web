<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Status</title>

        <!-- CSS -->
        <link href="css/history.css" rel="stylesheet" type="text/css"/>

        <!-- Scripts -->               
        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>    
        <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
        <script src="scripts/history.js" type="text/javascript"></script>
        
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Quicksand:300" rel="stylesheet">

    </head>
    <body>
        <div id="main_container">
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

                    <div id="content_header_container">
                        <div id="calendar">
                            <input id="date_picker" name="datetimes" type="image" src="images/icon_calendar.png"/>
                        </div>
                        <h1 id="content_title">                        
                            <a href="http://localhost:8080/Greenhouse_WebClient/history">Histórico de Status</a>
                        </h1>
                    </div>	

                    </br>                   

                    <table id="data_table">


                        <div id="myDivDataTest">
                            ${table_rows}
                        </div>


                    </table>
                </div>	

                <!-- Footer -->
                <div id="pre_footer">
                </div>               
                <div id="footer_container">
                    <span id="footer_text">
                        <b> Greenhouse Project </br> 2018 </b>
                    </span>
                </div>				

            </div>


        </div>
    </body>
</html>
