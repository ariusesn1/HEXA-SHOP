<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/laydulieu" prefix="f"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<c:if test="${isAdmin != 'true' }">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if>
<html>
<head>
<%@include file="head.jsp"%>
<script
	src="https://cdn.ckeditor.com/ckeditor5/37.1.0/classic/ckeditor.js"></script>
<meta charset="utf-8">
<title>Admin Panel</title>

</head>
<body>
	<%@include file="headerAd.jsp"%>
	<c:set var="soluong" value="3"></c:set>
	<c:choose>
		<c:when test="${param.vitri == nul}">
			<c:set var="vitri" value="0"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="vitri" value="${(param.vitri - 1)*3}"></c:set>
		</c:otherwise>
	</c:choose>
	<div class="content-wrapper">
		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<div class="col-xl">
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Add</h4>
									<c:if test="${param.id == null}">
										<form name="add" class="forms-sample" action="../SanPhamServlet"
											method="post" enctype="multipart/form-data" onsubmit="validateForm(event)">
											<div class="form-group">
												<label for="masp">Product Code</label> <input
													class="form-control" id="masp" type="text"
													name="masp">
											</div>
											<div style="color: red" id="error-message"></div>
											<div class="form-group">
												<label for="tensp">Name</label> <input
													class="form-control" id="tensp" type="text"
													name="tensp">
											</div>
											<div style="color: red" id="error-message2"></div>
											<div class="form-group">
												<label for="giaban">Price</label> <input
													class="form-control" id="giaban" type="number"
													name="giaban">
											</div>
											<div style="color: red" id="error-message3"></div>
											<div class="form-group">
												<label for="mtngan">Desc</label>
												<textarea class="form-control" id="mtngan" name="mtngan"></textarea>
											</div>
											<div id="error-message4"></div>
											<div class="form-group">
												<label for="chitiet">Detail</label>
												<textarea class="form-control" id="chitiet" name="chitiet"></textarea>
												
											</div>
											<div style="color: red" id="error-message5"></div>
											<div class="form-group">
												<label for="hinhanh">IMG</label> <input
													class="form-control" id="hinhanh" type="file"
													name="hinhanh">
											</div>
											<div style="color: red" id="error-message6"></div>
											<div class="form-group">
												<label for="exampleDanhmuc">Type</label> <select
													id="iddm" class="form-select" aria-label="Type" name="iddm">
													<c:forEach var="danhmuc" items="${f:getAllDanhMuc()}">
														<option value="${danhmuc.getId() }">${danhmuc.getTendanhmuc() }</option>
													</c:forEach>
												</select>
											</div>
										<button style="margin-top: 10px" type="submit"
											class="btn btn-secondary">Submit</button>
										</form>

									</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Edit</h4>
									<c:if test="${param.id != null}">
										<c:set var="spedit" value="${f:findById(param.id)}"></c:set>
										<form class="forms-sample" action="../UpdateSanpham"
											method="post" enctype="multipart/form-data">
											<div class="form-group row">
												<label for="id">ID</label> <input
													class="form-control" id="id" type="number"
													name="idsp" value="${spedit.getId()}">
											</div>
											<div class="form-group row">
												<label for="masp">Product Code</label> <input
													class="form-control" id="masp" type="text"
													name="masp" value="${spedit.getMasp()}">
											</div>
											<div class="form-group row">
												<label for="tensp">Name</label> <input
													class="form-control" id="tensp" type="text"
													name="tensp" value="${spedit.getTensp()}">
											</div>
											<div class="form-group row">
												<label for="giaban">Price</label> <input
													class="form-control" id="giaban" type="number"
													name="giaban" value="${spedit.getGiaban()}">
											</div>
											<div class="form-group row">
												<label for="mtngan">Desc</label>
												<textarea class="form-control" id="mtngan" name="mtngan"><c:out
														value="${spedit.getMotangan()}"></c:out></textarea>
											</div>
											<div class="form-group row">
												<label for="chitiet">Detail</label>
												<textarea class="form-control" name="chitiet" id="chitiet"><c:out
														value="${spedit.getChitiet()}"></c:out></textarea>
											</div>
											<div class="form-group row">
												<label for="hinhanh">IMG</label> <input
													class="form-control" id="hinanh" type="file"
													name="hinhanh">
											</div>
											<div class="form-group row">
												<label for="iddm">Type</label> <select id="iddm"
													class="form-select" aria-label="Type" name="iddm">
													<option value="${spedit.getIddanhmuc() }">${spedit.getIddanhmuc() }</option>
													<c:forEach var="danhmuc" items="${f:getAllDanhMuc()}">
														
														<option value="${danhmuc.getId() }">${danhmuc.getId() }</option>
													</c:forEach>
												</select>
											</div>
											<button style="margin-top: 10px;margin-left: 0px" type="submit" class="btn btn-secondary">Submit</button>
										</form>

									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="danhsachsanpham">
		<div class="card">
			<div class="table-responsive text-nowrap">
				<table class="table table-hover">
					<thead>
						<tr class="text-nowrap">
							<th>ID</th>
							<th>Prd code</th>
							<th>Name</th>
							<th>Price</th>
							<th>Detail</th>
							<th>Image</th>
							<th>Type</th>
						</tr>
					</thead>
					<tbody class="table-border-bottom-0">
						<c:forEach var="sanpham"
							items="${f:getAllSanphamPhanTrang(vitri,soluong)}">
							<tr>
								<td>${sanpham.getId() }</td>
								<td>${sanpham.getMasp()}</td>
								<td>${sanpham.getTensp() }</td>
								<td>${sanpham.getGiaban()}</td>
								<td>${sanpham.getChitiet() }</td>
								<td><img style="width: 120px; height: 80px"
									src="../hinhanhs/${sanpham.getHinhanh()}" alt="..."></td>
								<td>${sanpham.getIddanhmuc()}</td>
								<td>
									<div class="dropdown">
										<button type="button"
											class="btn p-0 dropdown-toggle hide-arrow"
											data-bs-toggle="dropdown">
											<i class="bx bx-dots-vertical-rounded"></i>
										</button>
										<div class="dropdown-menu">
											<a class="dropdown-item"
												href="../DeleteSanPham?id=${sanpham.getId() }"><i
												class="bx bx-trash me-1"></i>Delete</a> 
											<a class="dropdown-item"
												href="sanpham.jsp?id=${sanpham.getId() }"><i
												class="bx bx-edit-alt me-1"></i>Edit</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:choose>
				<c:when test="${param.q==null }">
					<c:set var="tong" value="${f:demSanpham()}"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="tong" value="${f:getTotalByKeyword(param.q)}"></c:set>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${tong%3!=0 }">
					<c:set var="sotrang" value="${tong/3 + 1}"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="sotrang" value="${tong/3}"></c:set>
				</c:otherwise>
			</c:choose>
			<ul>
				<li><c:forEach var="i" begin="1" end="${sotrang}" step="1">
						<a href="sanpham.jsp?vitri=${i }">${i }</a>
					</c:forEach></li>
			</ul>
		</div>
	</div>


	<%@include file="footer.jsp"%>
</body>
<script>
    ClassicEditor
        .create( document.querySelector( '#ghichu' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
<script>
    ClassicEditor
        .create( document.querySelector( '#mtngan' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
<script>
    ClassicEditor
        .create( document.querySelector( '#chitiet' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
<script>
	function validateForm(event) {
		event.preventDefault();

		var masp = document.forms["add"]["masp"].value;
		var tensp = document.forms["add"]["tensp"].value;
		var giaban = document.forms["add"]["giaban"].value;
		var mtngan = document.forms["add"]["mtngan"].value;
		var chitiet = document.forms["add"]["chitiet"].value;
		var hinhanh = document.forms["add"]["hinhanh"].value;
		
		// Get the error message container
		var errorMessage = document.getElementById("error-message");
		var errorMessage2 = document.getElementById("error-message2");
		var errorMessage3 = document.getElementById("error-message3");
		var errorMessage4 = document.getElementById("error-message4");
		var errorMessage5 = document.getElementById("error-message5");
		var errorMessage6 = document.getElementById("error-message6");
		
		// Reset the error message container
		errorMessage.innerHTML = "";
		errorMessage2.innerHTML = "";
		errorMessage3.innerHTML = "";
		errorMessage4.innerHTML = "";
		errorMessage5.innerHTML = "";
		errorMessage6.innerHTML = "";
		
		// Check each field for errors
		if (masp == "") {
			errorMessage.innerHTML += "Product code must be filled out<br>";
		}
		if (tensp == "") {
			errorMessage2.innerHTML += "Product name must be filled out<br>";
		}
		if (giaban == "") {
			errorMessage3.innerHTML += "Price must be filled out<br>";
		}
		if (mtngan == "") {
			errorMessage4.innerHTML += "Description ngan must be filled out<br>";
		}
		if (chitiet == "") {
			errorMessage5.innerHTML += "Detail must be filled out<br>";
		}
		if (hinhanh == "") {
			errorMessage6.innerHTML += "Image file must be choose<br>";
		}
		// If there are errors, do not submit the form
		if (errorMessage.innerHTML !== "") {
			return false;
		}
		if (errorMessage2.innerHTML !== "") {
			return false;
		}
		if (errorMessage3.innerHTML !== "") {
			return false;
		}
		if (errorMessage4.innerHTML !== "") {
			return false;
		}
		if (errorMessage5.innerHTML !== "") {
			return false;
		}

		// If all fields are valid, submit the form
		document.forms["add"].submit();
	}
</script>

</html>