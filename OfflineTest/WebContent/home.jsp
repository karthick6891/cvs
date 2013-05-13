<%@page isELIgnored="true"%>
<!DOCTYPE html>
<!--[if IEMobile 7 ]>    <html class="no-js iem7"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="cleartype" content="on">

<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="img/touch/apple-touch-icon-144x144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="img/touch/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="img/touch/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="img/touch/apple-touch-icon-57x57-precomposed.png">
<link rel="shortcut icon" href="img/touch/apple-touch-icon.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
	content="img/touch/apple-touch-icon-144x144-precomposed.png">
<meta name="msapplication-TileColor" content="#222222">


<!-- For iOS web apps. Delete if not needed. https://github.com/h5bp/mobile-boilerplate/issues/94 -->
<!--
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="">
        -->

<!-- This script prevents links from opening in Mobile Safari. https://gist.github.com/1042026 -->
<!--
        <script>(function(a,b,c){if(c in b&&b[c]){var d,e=a.location,f=/^(a|html)$/i;a.addEventListener("click",function(a){d=a.target;while(!f.test(d.nodeName))d=d.parentNode;"href"in d&&(d.href.indexOf("http")||~d.href.indexOf(e.host))&&(a.preventDefault(),e.href=d.href)},!1)}})(document,window.navigator,"standalone")</script>
        -->

<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="css/standard.css"></link>

<script src="js/vendor/modernizr-2.6.2.min.js"></script>
</head>
<body data-spy="scroll" data-target=".subnav" data-offset="50">
	<!-- Add your site or application content here -->


	<div class="wrapper">
		<div id="site-header">

			<!-- BEGIN: Site Header Content. -->
			<div id="site-header-content">

				<ul id="site-navigation">
					<li><a href="#/Events" rel="home">Events</a></li>
					<li><a href="#/videos" rel="videos">Videos</a></li>
					<li><a href="#/resources" rel="resources">Lecture Notes</a></li>
				</ul>


			</div>
			<!-- END: Site Header Content. -->

		</div>
		<div class="content-wrapper">
			<div class="content">

				<!-- BEGIN: Primary Content Stages. -->
				<ul id="primary-content-stages">

					<!-- BEGIN: Primary Content Stage :: Home. -->
					<li rel="home"
						class="primary-content-stage current-primary-content-stage">

						<h1>Event List</h1>

						<p>Technical Events/Seminars around the world are listed here
							please click on the respective link to register</p>

						<p>
							<!--<strong>C</strong>lient-<strong>O</strong>nly-<strong>R</strong>equired
							<strong>M</strong>odel-<strong>V</strong>iew-<strong>C</strong>ontroller,-->

						</p>

						<h2>Event Calendar</h2>

						<p></p>

						<ol id="eventListTarget">
							<script type="text/html" id='eventListTemplate'>
								<@
								_.each(events,function(events,key,list){
								var f = events.eventName.split("").shift().toLowerCase();
								console.log("F: " + f);
								@> 
								
								<li>
								<@= events.eventName @>  <a href="#"><em>Click to register</em></a> for the event	
								</li>
								
								<@
									});
								@>
							</script>
						</ol></li>
					<!-- END: Primary Content Stage :: Home. -->


					<!-- BEGIN: Primary Content Stage :: Documentation. -->
					<li rel="videos" class="primary-content-stage">


						<h1>Videos</h1>

						<p>See the technical seminars over here</p>

						<p>
							<em>Coming soon....</em>
						</p></li>
					<!-- END: Primary Content Stage :: Documentation. -->

					<!-- BEGIN: Primary Content Stage :: Resources. -->
					<li rel="resources" class="primary-content-stage">


						<h1>Resources</h1>

						<p>This is the resources page.</p>

						<p>
							<em>Coming soon....</em>
						</p></li>
					<!-- END: Primary Content Stage :: Resources. -->



				</ul>
				<!-- END: Primary Content Stages. -->

			</div>
		</div>

	</div>
	<!--end wrapper-->

	<footer> Copyright @ santhana_s01</footer>


	<script src="js/vendor/jquery-1.9.1.min.js"></script>
	<script src="js/vendor/underscore-min.js"></script>
	<script src="js/helper.js"></script>
	<script src="js/manageoffline.js"></script>

	<!-- NOTE: memorystore.js will set up an in-memory datastore to allow you to experience the app without setting up
		back-end infrastructure. All the changes you make to the data will be lost the next time you access the app or hit Refresh.
		To use the app with a persistent RESTful back-end (provided in the GitHub repo), simply comment out the line below. -->
	<!-- <script src="js/memorystore.js"></script>-->

	<script src="js/main.js"></script>
	<script src="js/home.js"></script>



	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
	<!--<script>
            var _gaq=[["_setAccount","UA-XXXXX-X"],["_trackPageview"]];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];g.async=1;
            g.src=("https:"==location.protocol?"//ssl":"//www")+".google-analytics.com/ga.js";
            s.parentNode.insertBefore(g,s)}(document,"script"));
        </script>-->
</body>
</html>
