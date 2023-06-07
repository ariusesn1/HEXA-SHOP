<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/laydulieu" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/head.jsp"%>
<meta charset="utf-8">
<title>Products List</title>
</head>
<body>
	<%@include file="include/header.jsp"%>

	<c:set var="soluong" value="6"></c:set>
	<c:choose>
		<c:when test="${param.vitri == nul}">
			<c:set var="vitri" value="0"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="vitri" value="${(param.vitri - 1)*6}"></c:set>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${param.q==null}">
			<c:choose>
				<c:when test="${param.sort=='asc'}">
					<c:set var="listSanPham"
						value="${f:getAllSanphamPhanTrangPriceUp(vitri,soluong)}"></c:set>
				</c:when>
				<c:when test="${param.sort=='desc'}">
					<c:set var="listSanPham"
						value="${f:getAllSanphamPhanTrangPriceDown(vitri,soluong)}"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="listSanPham"
						value="${f:getAllSanphamPhanTrang(vitri,soluong)}"></c:set>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:set var="listSanPham" value="${f:search(param.q,vitri,soluong)}"></c:set>
		</c:otherwise>
	</c:choose>


	<div class="page-heading" id="top">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="inner-content">
						<h2>Check Our Products</h2>
						<span>Awesome &amp; Creative HTML CSS layout by TemplateMo</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Main Banner Area End ***** -->
	<!-- ***** Products Area Starts ***** -->
	<section class="section" id="products">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h2>Our Latest Products</h2>
						<span>Check out all of our products.</span>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<form method="get" class="row" style="margin-bottom: 30px">
				<div class="col">
					<input class="form-control" name="q" type="text">
				</div>
				<div class="col-md-auto">
					<button class="btn btn-outline-dark" type="submit">Search</button>
				</div>
				<div class="col-md-auto">
					<a class="btn btn-outline-dark" href="?sort=asc">Price(Ascend)</a>
					<a class="btn btn-outline-dark" href="?sort=desc">Price(Descend)</a>
				</div>
			</form>
			<div class="row">
				<c:forEach var="sanpham" items="${listSanPham}">
					<div class="col-lg-4">
						<div class="item">
							<div class="thumb">
								<div class="hover-content">
									<ul>
										<li><a href="single-product.jsp?idsp=${sanpham.getId() }"><i
												class="fa fa-eye"></i></a></li>
										<li><a href="single-product.jsp?idsp=${sanpham.getId() }"><i
												class="fa fa-star"></i></a></li>
										<li><a href="single-product.jsp?idsp=${sanpham.getId() }"><i
												class="fa fa-shopping-cart"></i></a></li>
									</ul>
								</div>
								<img style="width: 350px; height: 233.7px"
									src="hinhanhs/${sanpham.getHinhanh()}" alt="...">
							</div>
							<div class="down-content">
								<h4>${sanpham.getTensp() }</h4>
								<span>${sanpham.getGiaban()}$</span>
								<ul class="stars">
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-lg-12">
			<nav>
				<c:choose>
					<c:when test="${param.q==null }">
						<c:set var="tong" value="${f:demSanpham()}"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="tong" value="${f:getTotalByKeyword(param.q)}"></c:set>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${tong%6!=0 }">
						<c:set var="sotrang" value="${tong/6 + 1}"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="sotrang" value="${tong/6}"></c:set>
					</c:otherwise>
				</c:choose>
				<ul class="pagination">
					<li class="page-item"><c:forEach var="i" begin="1" end="${sotrang}" step="1">
							<a class="page-link" href="products.jsp?vitri=${i }">${i }</a>
						</c:forEach></li>
				</ul>
			</nav>
		</div>
	</section>
	<%@include file="include/footer.jsp"%>
</body>
</html>