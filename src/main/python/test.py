# -*- coding: utf-8 -*-
"""
Created on Fri Nov  2 07:02:17 2018

@author: q0hecgsk
"""

from pathlib import Path
def touch(fpath):
    Path(fpath).touch()
    
touch(r"C:\Users\q0hecgsk\Desktop\touch.txt")