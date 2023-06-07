<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header-area header-sticky">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="main-nav">
					<!-- ***** Logo Start ***** -->
					<a href="main.jsp" class="logo"> <img
						src="assets/images/logo.png">
					</a>
					<!-- ***** Logo End ***** -->
					<!-- ***** Menu Start ***** -->
					<ul class="nav">
						<li class="scroll-to-section"><a href="main.jsp"
							>Home</a></li>
						<li><a href="products.jsp">Products</a></li>
						<li class="submenu"><a href="javascript:;">Pages</a>
							<ul>
								<li><a href="about.jsp">About Us</a></li>
								<li><a href="products.jsp">Products</a></li>
								<li><a href="contact.jsp">Contact Us</a></li>
							</ul></li>
						<c:choose>
								<c:when test="${userlogin != 'true' }">
									<li class="scroll-to-section"><a href="login.jsp"
										class="scroll-to-section">Login</a></li>
								</c:when>
								<c:otherwise>
									<li class="scroll-to-section"><a href="logout.jsp"
										class="scroll-to-section">Logout</a></li>
								</c:otherwise>
							</c:choose>
					</ul>
					<a class='menu-trigger'> <span>Menu</span>
					</a>
					<!-- ***** Menu End ***** -->
				</nav>
			</div>
		</div>
	</div>
</header>