import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmRpIiwiaWF0IjoxNjczMDYzNjcxLCJleHAiOjE2NzMxNTAwNzF9.8KaGC1ynYaXu3v4lyHLS5GRLPnVBl3uypFD3H1m4rHpDwQzEUnc0v0Lfdvu-bIi1LkQDxEEJgZyxfMPXA85fjg', 
    "Content-type": "application/json"
  }
});