import { TestBed } from '@angular/core/testing';

import { FirstentityService } from './firstentity.service';

describe('FirstentityService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FirstentityService = TestBed.get(FirstentityService);
    expect(service).toBeTruthy();
  });
});
