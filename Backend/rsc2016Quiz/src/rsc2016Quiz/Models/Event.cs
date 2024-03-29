﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace rsc2016Quiz.Models
{
    public class Event
    {
        public int Id { get; set; }

        public string Name { get; set; }
        [Required]
        public string Place { get; set; }

        [Required]
        public string DateTime { get; set; }
        public string Description { get; set; }
        public int MaxMemberPerTeam { get; set; }
        [DefaultValue(true)]
        public bool IsOpen { get; set; }

        [ForeignKey("User")]
        public string UserId { get; set; }
        public User User { get; set; }

        public ICollection<Team> Teams { get; set; } = new List<Team>();

        

    }
}
