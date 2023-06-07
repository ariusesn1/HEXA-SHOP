<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/laydulieu" prefix="f"%>
<c:if test="${isAdmin != 'true' }">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if>
<html>
<head>
<%@include file="head.jsp"%>
<meta charset="utf-8">
<title>Admin Panel</title>
</head>
<body>
	<%@include file="headerAd.jsp"%>
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
										<form class="mx-1 mx-md-4" action="../DanhMucServlet"
											method="post">
											<div class="form-group">
												<label class="form-label" for="tendm">Tên danh mục</label> <input
													class="form-control" type="text" id="tendm" name="tendm">
											</div>
											<div class="form-group">
												<label class="form-label" for="mota">Mô tả</label> <input
													class="form-control" type="text" id="mota" name="mota">
											</div>
											<div style="margin-top: 15px" class=" flex-fill mb-0">
												<input style="margin-top: 15px" class="btn btn-secondary"
													type="submit" value="Thêm">
											</div>
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
										<c:set var="dmedit" value="${f:findByIdDM(param.id)}"></c:set>

										<form class="mx-1 mx-md-4" action="../UpdateDanhMuc"
											method="post">
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="id">ID</label> <input
														class="form-control" type="number" id="id" name="id"
														value="${dmedit.getId()}">
												</div>
											</div>
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="tendm">Tên danh mục</label>
													<input class="form-control" type="text" id="tendm"
														name="tendm" value="${dmedit.getTendanhmuc()}">
												</div>
											</div>
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="mota">Mô tả</label>
													<textarea class="form-control" id="mota" name="mota"><c:out
															value="${dmedit.getMota()}"></c:out></textarea>
												</div>
											</div>
											<input style="margin-top: 15px" class="btn btn-secondary"
												type="submit" value="Cập nhật">
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

	<div class="danhsachaccount">
		<div class="card">
			<div class="table-responsive text-nowrap">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Type name</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody class="table-border-bottom-0">
						<c:forEach var="danhmuc" items="${f:getAllDanhMuc()}">
							<tr>
								<td>${danhmuc.getId() }</td>
								<td>${danhmuc.getTendanhmuc()}</td>
								<td>${danhmuc.getMota() }</td>
								<td>
									<div class="dropdown">
										<button type="button"
											class="btn p-0 dropdown-toggle hide-arrow"
											data-bs-toggle="dropdown">
											<i class="bx bx-dots-vertical-rounded"></i>
										</button>
										<div class="dropdown-menu">
											<a class="dropdown-item"
												href="../deletedm?id=${danhmuc.getId() }"><i
												class="bx bx-trash me-1"></i>Delete</a> 
											<a class="dropdown-item"
												href="danhmuc.jsp?id=${danhmuc.getId() }"><i
												class="bx bx-edit-alt me-1"></i>Edit</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>