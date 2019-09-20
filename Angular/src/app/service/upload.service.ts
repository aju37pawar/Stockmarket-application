import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  baseUrl: String = 'http://localhost:8992';

  constructor(private http: HttpClient) { }

  pushFileToStorage(file: File, fileName: any): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('file', file, fileName);

    const req = new HttpRequest('POST', `${this.baseUrl}/import`, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
}
