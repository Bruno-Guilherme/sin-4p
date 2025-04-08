// api.js
import axios from "axios";

const APP_ID = "SUA_APP_ID";
const REST_KEY = "SUA_REST_API_KEY";
const SERVER_URL = "https://parseapi.back4app.com";

const api = axios.create({
  baseURL: `${SERVER_URL}/classes/Todo`,
  headers: {
    "X-Parse-Application-Id": APP_ID,
    "X-Parse-REST-API-Key": REST_KEY,
    "Content-Type": "application/json",
  },
});

export default api;
