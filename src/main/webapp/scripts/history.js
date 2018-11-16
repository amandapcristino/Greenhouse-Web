 $(function () {
                $('input[name="datetimes"]').daterangepicker({
                    showDropdowns: false,
                    opens: 'left',
                    startDate: moment().startOf('hour'),
                    endDate: moment().startOf('hour').add(32, 'hour'),
                    locale: {
                        format: 'DD-MM-YYYY',
                        separator: ':',
                        applyLabel: 'Selecionar',
                        cancelLabel: 'Cancelar',
                        fromLabel: 'De',
                        toLabel: 'Até',
                        daysOfWeek: [
                            'D',
                            'S',
                            'T',
                            'Q',
                            'Q',
                            'S',
                            'S'
                        ],
                        monthNames: [
                            'Janeiro',
                            'Fevereiro',
                            'Março',
                            'Abril',
                            'Maio',
                            'Junho',
                            'Julho',
                            'Agosto',
                            'Setembro',
                            'Outubro',
                            'Novembro',
                            'Dezembro'
                        ],
                        firstDay: 1
                    }
                });
            });

            $(document).ready(function () {
                $(document).on('click', '.applyBtn', function () {

                    var dates = $("#date_picker").val();
                    $.ajax({
                        type: 'POST',
                        data: {"date_range": dates},
                        dataType: 'text',
                        url: 'history',
                        success: function (data) {
                            $('#data_table').html(data);
                        }
                    }).fail(function (error, log) {
                        alert("Error" + error + " :::: " + log);
                    });
                });
            });