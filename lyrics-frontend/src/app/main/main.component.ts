import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Song } from '../model/song';
import { APIService } from '../services/api.service';
/**
 * @autor santiago Cárdenas
 * @version 1.0
 * @date 19/12/2020
 */
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private fb: FormBuilder, private service: APIService) { }

  songForm: FormGroup;
  songInformation: Song;
  lyrics: String;
  clear: boolean = false;
  title = 'Lyrics Finder';
  isAlert:boolean=false;

  ngOnInit(): void {

    this.songForm = this.fb.group({
      artist: ["", Validators.required],
      title: ["", Validators.required]
    })
  }
/**
 * Get information from API
 */
  getAPIInformation() {
    this.service.getAPIiNFO(this.songInformation).subscribe((data) => {
      this.lyrics = data.lyrics;
      if(this.lyrics.length==0){
        this.isAlert = true;
      }
      console.log(this.lyrics);
    })
  }

/**
 * Set values from the UI
 */
  setValues() {
    console.log(this.songForm.get('artist').value);
    console.log(this.songForm.get('title').value);
    this.songForm.setValue(
      {
        artist: this.songForm.get('artist').value,
        title: this.songForm.get('title').value
      }
    )
    this.clear = true;
    this.songInformation = this.songForm.value;
    this.getAPIInformation();
    this.clearValues();
  }
/**
 * Clear the user`s values
 */
  clearValues() {
    this.songForm.clearValidators();
    this.songForm = this.fb.group({
      artist: ["", Validators.required],
      title: ["", Validators.required]
    })
  }

  isAlertOn(){
    this.isAlert = false;
  }


  getLyricsTranslated() {
    this.service.getAPIiNFO(this.songInformation).subscribe((data) => {
      this.lyrics = data.lyrics;
      if(this.lyrics.length==0){
        this.isAlert = true;
      }
      console.log(this.lyrics);
    })
  }

}
