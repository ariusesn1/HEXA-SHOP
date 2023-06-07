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
										<form class="mx-1 mx-md-4" action="../AccountServlet"
											method="post">
											<div class="form-group">
												<label class="form-label" for="username">Username</label> <input
													class="form-control" type="text" id="username" name="username">
											</div>
											<div class="form-group">
												<label class="form-label" for="password">Password</label> <input
													class="form-control" type="text" id="password" name="password">
											</div>
											<div class="form-group">
												<label class="form-label" for="email">Email</label> <input
													class="form-control" type="email" id="email" name="email">
											</div>
											<label style="margin-top: 10px" class="form-label" for="role">Role</label>
											<select id="role"  class="form-select"
												aria-label="Role" name="role">
												<option value="Admin">Admin</option>
												<option value="User">User</option>
											</select>
											<div style="margin-top: 10px" class=" flex-fill mb-0">
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
									<h4 class="card-title">Add</h4>
									<c:if test="${param.id != null}">
										<c:set var="accedit" value="${f:findByIdAcc(param.id)}"></c:set>
										<form class="mx-1 mx-md-4" action="../UpdateAccount"
											method="post">
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="ghichu">ID</label> <input
														class="form-control" type="number" id="id" name="id"
														value="${accedit.getId()}">
												</div>
											</div>
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="ghichu">Username</label>
													<input class="form-control" type="text" id="username"
														name="username" value="${accedit.getUsername()}">
												</div>
											</div>
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="ghichu">Password</label>
													<input class="form-control" type="text" id="password"
														name="password" value="${accedit.getPassword()}">
												</div>
											</div>
											<div class="d-flex flex-row align-items-center mb-4">
												<div class=" flex-fill mb-0">
													<label class="form-label" for="ghichu">Email</label> <input
														class="form-control" type="email" id="email"
														name="email" value="${accedit.getEmail()}">
												</div>
											</div>
											<label style="margin-top: 10px" class="form-label" for="role">Role</label>
											<select id="role"  class="form-select"
												aria-label="Role" name="role">
												<option value="${accedit.getRole()}">${accedit.getRole()}</option>
												<option value="Admin">Admin</option>
												<option value="User">User</option>
											</select>
											<input style="margin-top: 10px" class="btn btn-secondary"
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
					<th>Username</th>
					<th>Password</th>
					<th>Email</th>
					<th>Role</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${f:getAllAccount()}">
					<tr>
						<td>${account.getId() }</td>
						<td>${account.getUsername()}</td>
						<td>${account.getPassword() }</td>
						<td>${account.getEmail()}</td>
						<td>${account.getRole()}</td>
						<td>
							<div class="dropdown">
								<button type="button"
									class="btn p-0 dropdown-toggle hide-arrow"
									data-bs-toggle="dropdown">
									<i class="bx bx-dots-vertical-rounded"></i>
								</button>
								<div class="dropdown-menu">
									<a class="dropdown-item"
										href="../DeleteAccount?id=${account.getId() }"><i
										class="bx bx-trash me-1"></i>Delete</a> <a class="dropdown-item"
										href="account.jsp?id=${account.getId() }"><i
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
</body>
</html>