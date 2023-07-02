<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Product Admin - Dashboard HTML Template</title>
    



</head>
<body>
	<footer class="tm-footer row tm-mt-small">
	<div class="col-12 font-weight-light">
		<p class="text-center text-white mb-0 px-4 small">
			Copyright &copy; <b>2018</b> All rights reserved.
		</p>
	</div>
	</footer>
	
	<script type="text/javascript" src="<c:url value='/template/admin/js/jquery-3.3.1.min.js' />"></script>
	
    <!-- https://jquery.com/download/ -->
    <script type="text/javascript" src="<c:url value='/template/admin/js/moment.min.js' />"></script>
   
    <!-- https://momentjs.com/ -->
    <script type="text/javascript" src="<c:url value='/template/admin/js/Chart.min.js' />"></script>
    
    <!-- http://www.chartjs.org/docs/latest/ -->
    <script type="text/javascript" src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>
   
    <!-- https://getbootstrap.com/ -->
    <script type="text/javascript" src="<c:url value='/template/admin/js/tooplate-scripts.js' />"></script>
    
   	<script>
        Chart.defaults.global.defaultFontColor = 'white';
        let ctxLine,
            ctxBar,
            ctxPie,
            optionsLine,
            optionsBar,
            optionsPie,
            configLine,
            configBar,
            configPie,
            lineChart;
        barChart, pieChart;
        // DOM is ready
        $(function () {
            drawLineChart(); // Line Chart
            drawBarChart(); // Bar Chart
            drawPieChart(); // Pie Chart

            $(window).resize(function () {
                updateLineChart();
                updateBarChart();                
            });
        })
    </script>
</body>
</html>
