<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/laydulieu" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/head.jsp"%>
<meta charset="utf-8">
<title>Product Detail</title>
</head>
<body>
	<c:set var="sanpham" value="${f:findById(param.idsp)}"></c:set>
	<%@include file="include/header.jsp"%>
	<div class="page-heading" id="top">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="inner-content">
						<h2>Single Product Page</h2>
						<span>Product Detail</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** Product Area Starts ***** -->
	<section class="section" id="product">

		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="left-images">
						<img src="hinhanhs/${sanpham.getHinhanh()}" alt="...">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="right-content">
						<h4>${sanpham.getTensp() }</h4>
						<span class="price">${sanpham.getGiaban()}$</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
						<span>${sanpham.getMotangan()}</span>
						<div class="quote">
							<i class="fa fa-quote-left"></i>
							<p>${sanpham.getChitiet() }.</p>
						</div>
						<div class="quantity-content">
							<div class="left-content">
								<h6>No. of Orders</h6>
							</div>
							<div class="right-content">
								<div class="quantity buttons_added">
									<input type="button" value="-" class="minus"><input
										type="number" step="1" min="1" max="" name="quantity"
										value="1" title="Qty" class="input-text qty text" size="4"
										pattern=""><input type="button" value="+"
										class="plus">
								</div>
							</div>
						</div>
						<div class="total">
							<div class="main-border-button">
								<a href="#">Add To Cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="include/footer.jsp"%>
</body>
</html>