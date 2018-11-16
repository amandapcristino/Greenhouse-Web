function checkboxClick() {
    $(document).ready(function () {
        var light = $("#input_light").prop('checked');
        var water = $("#input_water").prop('checked');
        var exaust = $("#input_exaust").prop('checked');
        
        $.ajax({
            type: 'POST',
            data: {"input_light": light,
                "input_water": water,
                "input_exaust": exaust},
            url: 'home',
            success: function () {
                
            }
        });
    });
};
