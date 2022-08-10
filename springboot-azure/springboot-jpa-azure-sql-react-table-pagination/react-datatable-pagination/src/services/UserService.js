import http from "../http-common";

const get = (id) => {
  return http.get(`/users/${id}`);
};

const create = (data) => {
  return http.post("/users", data);
};

const update = (id, data) => {
  return http.put(`/users/${id}`, data);
};

const remove = (id) => {
  return http.delete(`/users/${id}`);
};

const getAll = (params) => {
  return http.get("/users", { params });
};

const UserService = {
  getAll,
  get,
  create,
  update,
  remove
};

export default UserService;
