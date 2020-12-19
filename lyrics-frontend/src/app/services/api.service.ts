import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Song } from '../model/song';

@Injectable({
  providedIn: 'root'
})
export class APIService {

  constructor(private http: HttpClient) { }

  url = `${environment.url}`

  getAPIiNFO(song:Song): Observable<any> {
    return this.http.get(this.url+song.artist+"/"+song.title);
  }
}
