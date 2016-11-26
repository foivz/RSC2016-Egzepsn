﻿using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DiagnosticAdapter.Internal;

namespace rsc2016Quiz.Models
{
    public class RscContext : IdentityDbContext<User>
    {
        public DbSet<Team> Teams { get; set; }
        public DbSet<Event> Events { get; set; }
        public DbSet<TeamMember> TeamMembers { get; set; }
        public DbSet<Question> Questions { get; set; }
        public DbSet<Answer>  Answers { get; set; }
        public DbSet<QuestionEvent> QuestionEvents { get; set; }

        public RscContext(DbContextOptions<RscContext> options) : base(options)
        {
            Database.Migrate();
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TeamMember>()
                .HasKey(pf => new {pf.TeamId, pf.UserId});

            modelBuilder.Entity<QuestionEvent>()
               .HasKey(pf => new { pf.QuestionId, pf.EventId });

            modelBuilder.Entity<QuestionEvent>()
                .HasOne(qe => qe.Event)
                .WithMany(q => q.QuestionEvents)
                .HasForeignKey(qe => qe.QuestionId);


            base.OnModelCreating(modelBuilder);
        }
    }
}
