import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Song } from '../model/song';
/**
 * This is a service class to call the API
 * @auto Santiago Cárdenas
 * @version 1.0
 * @date 12/19/2020
 */
@Injectable({
  providedIn: 'root'
})
export class APIService {

  constructor(private http: HttpClient) { }

  url = `${environment.url}`;
  urlTranslate = `${environment.APITranslate}`

  /**
   * Method to call the API
   * @param song 
   * @returns if found returns the lyric of the song from the API else returns ''
   */
  getAPIiNFO(song:Song): Observable<any> {
    return this.http.get(this.url+song.artist+"/"+song.title);
  }


  /**
   * Method to call the API translator
   * @param song 
   * @returns Song translated
   */
  translateLyrics(song:Song): Observable<any> {
    return this.http.post<Song>(this.urlTranslate,song);
  }
}