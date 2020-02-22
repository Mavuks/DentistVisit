import http from "../http-common";

class DentistDataService {
  getAll() {
    return http.get("/appointments");
  }

  get(id) {
    return http.get(`/appointments/${id}`);
  }

  create(data) {
    return http.post("/", data);
  }

  update(id, data) {
    return http.put(`/appointments/${id}`, data);
  }

  delete(id) {
    return http.delete(`/appointments/${id}`);
  }

  deleteAll() {
    return http.delete(`/appointments`);
  }

 /*  findByTitle(title) {
    return http.get(`/appointments?title=${title}`);
  } */
}

export default new DentistDataService();